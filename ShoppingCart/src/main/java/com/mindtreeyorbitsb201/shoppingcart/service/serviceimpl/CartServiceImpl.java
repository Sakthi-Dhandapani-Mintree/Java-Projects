package com.mindtreeyorbitsb201.shoppingcart.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;
import com.mindtreeyorbitsb201.shoppingcart.entity.User;
import com.mindtreeyorbitsb201.shoppingcart.exception.CartIdNotFoundException;
import com.mindtreeyorbitsb201.shoppingcart.exception.ProductNotFoundException;
import com.mindtreeyorbitsb201.shoppingcart.exception.UserNotFoundException;
import com.mindtreeyorbitsb201.shoppingcart.repository.CartRepository;
import com.mindtreeyorbitsb201.shoppingcart.repository.ProductRepository;
import com.mindtreeyorbitsb201.shoppingcart.repository.UserRepository;
import com.mindtreeyorbitsb201.shoppingcart.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	private static Logger logger = LogManager.getLogger(CartServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Cart addProducts(Cart cart, Integer userId, Integer productId) {

		logger.info("|| CartServiceImpl  entry: addProducts to user " + userId + " with product id is : " + productId);
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found in DB with Given userId :" + userId));
		cart.setUser(user);
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
		logger.info("|| CartServiceImpl end: added products to the cart ");

		return cart;

	}

	public int getQuantity(Cart cart) {
		logger.error("|| getQuantity : getQuantity to update the existing count " + cart.getQuantity());
		int totalQuantity = 0;
		Optional<Cart> carts = cartRepository.findById(cart.getCartId());
		totalQuantity = carts.get().getQuantity() + cart.getQuantity();
		logger.error("|| getQuantity : getQuantity updated with existing count " + totalQuantity);
		return totalQuantity;
	}

	@Override
	public Cart updateProducts(Cart crt) {
		logger.info("Updating the Products from the Cart --->" + crt.getCartId());
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
		logger.info("|| CartServiceImpl entry : removeProducts from the cartId " + productId);
		Product product = productRepository.findByProductId(productId);
		productRepository.deleteById(productId);
		
		logger.info("|| CartServiceImpl end : removeProducts from the cartId ");

	}

	@Override
	public void removeAllProducts(Integer cartId) {
		logger.info("|| CartServiceImpl entry : removeAllProducts based on cartId " + cartId);
		productRepository.deleteAll();
		logger.info("|| CartServiceImpl entry : removeAllProducts based on cartId " + cartId);
		Cart cart = cartRepository.findById(cartId).orElseThrow(
				() -> new CartIdNotFoundException("Cart is not found in the DB with given cartId : " + cartId));
		cartRepository.delete(cart);
		logger.info("|| CartServiceImpl end : Removed products as well as CartId  " + cartId);

	}

	@Override
	public Cart viewProducts(Integer cartId) {
		logger.info("|| CartServiceImpl  entry: viewProducts base on the cart id " + cartId);
		Cart cart = cartRepository.findByCartId(cartId);
		if (cart == null) {
			logger.error("|| CartServiceImpl  : viewProducts not find the " + cartId);
			throw new CartIdNotFoundException("Entered Cart Id : " + cartId + " not found in the DB");
		}
		List<Product> pd = productRepository.findByCart(cart);
		cart.setProduct(pd);
		logger.info("|| CartServiceImpl  end: displayed all the product to cart");
		return cart;
	}

}