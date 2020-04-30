package com.mindtreeyorbitsb201.shoppingcart.service.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;
import com.mindtreeyorbitsb201.shoppingcart.entity.User;
import com.mindtreeyorbitsb201.shoppingcart.exception.CartIdNotFoundException;
import com.mindtreeyorbitsb201.shoppingcart.exception.UserNotFoundException;
import com.mindtreeyorbitsb201.shoppingcart.repository.CartRepository;
import com.mindtreeyorbitsb201.shoppingcart.repository.ProductRepository;
import com.mindtreeyorbitsb201.shoppingcart.repository.UserRepository;
import com.mindtreeyorbitsb201.shoppingcart.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	private static Logger log = LogManager.getLogger(CartServiceImpl.class);
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Cart addProducts(Cart cart, Integer userId, Integer productId) {
		log.info("-->Add Products with {} number of times into {}" + productId + " " + userId);
		try {
			User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user Not Found"));
			cart.setUser(user);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}

		Product products = productRepository.findByProductId(productId);
		Optional<Cart> carts = cartRepository.findById(cart.getCartId());
		if (!carts.isPresent()) {
			double totalAmount = products.getProductPrice() * cart.getQuantity();
			cart.setCartId(cart.getCartId());
			cart.setQuantity(cart.getQuantity());
			cart.setTotalAmount(totalAmount);
			products.setCart(cart);

			cartRepository.save(cart);
		} else {
			double totalAmount = carts.get().getTotalAmount() + (products.getProductPrice() * cart.getQuantity());
			cart.setQuantity(carts.get().getQuantity() + cart.getQuantity());
			cart.setCartId(cart.getCartId());
			cart.setTotalAmount(totalAmount);
			products.setCart(cart);
			cartRepository.save(cart);
		}

		return cart;

	}

	public int getQuantity(Cart cart) {
		int totalQuantity = 0;
		Optional<Cart> carts = cartRepository.findById(cart.getCartId());
		totalQuantity += carts.get().getQuantity();
		return totalQuantity;
	}

	@Override
	public Cart updateProducts(Cart crt) {
		log.info("Updating the Products from the Cart --->" + crt.getCartId());
		try {
			Cart cart = cartRepository.findById(crt.getCartId())
					.orElseThrow(() -> new CartIdNotFoundException("Cart Id Not Found in the Data base"));
			if (cart.getQuantity() > 0) {
				int originalValue = cart.getQuantity();
				int subtract = originalValue - cart.getQuantity();
				cart.setQuantity(subtract);
				cartRepository.save(cart);
			}

		} catch (CartIdNotFoundException ct) {
			System.out.println(ct.getMessage());
		}

		return null;
	}

	@Override
	public void removeProducts(Integer cartId, Integer productId) {
		Product p = productRepository.findByProductId(productId);
		productRepository.deleteById(p.getProductId());

	}

	@Override
	public Cart viewProducts(Integer cartId) {
		Cart crt = cartRepository.findByCartId(cartId);
		crt.setProduct(collectDataFromNameQuery(cartId));
		return crt;
	}

	private Collection<Product> collectDataFromNameQuery(Integer cartId) {
		EntityManager em = emf.createEntityManager();
		Query query = em
				.createNamedQuery("SELECT C.QUANTITY, PRODUCT_ID ,PRODUCT_CATEGORY,PRODUCT_NAME FROM PRODUCT P\r\n"
						+ "JOIN CART  AS C ON P.CART_ID =" + cartId);
		@SuppressWarnings("unchecked")
		List<Product> product = query.getResultList();
		em.clear();
		return product;
	}

}