package com.mindtreeyorbitsb201.shoppingcart.service.serviceimpl;

import java.util.ArrayList;
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
	List<Product> products = new ArrayList<Product>();
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	private float totalAmount;

	@Override
	public Cart addProducts(Cart cart, Integer userId, Integer productId) {
		logger.info("|| CartServiceImpl  entry: addProducts to user " + userId + " with product id is : " + productId);
		Optional<User> user = userRepository.findById(userId);
				
		cart.setUser(user.get());
		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductNotFoundException("Entered Product Id is not found in the DB :" + productId));
		products.add(product);
		logger.info("Cart id will be stored ---->"+cart.getCartId());
		Optional<Cart> carts = cartRepository.findById(cart.getCartId());
		if (!carts.isPresent()) {
			
			totalAmount = product.getProductPrice() * cart.getQuantity();
			cart.setCartId(cart.getCartId());
			cart.setQuantity(cart.getQuantity());
			cart.setTotalAmount(totalAmount);
			cart.setProduct(products);
			logger.info("Cart id will be getted ---->"+cart.getCartId());
			cartRepository.save(cart);
		} else {
			
			totalAmount = carts.get().getTotalAmount() + (product.getProductPrice() * cart.getQuantity());
			cart.setQuantity(carts.get().getQuantity() + cart.getQuantity());
			cart.setCartId(cart.getCartId());
			cart.setTotalAmount(totalAmount);
			cart.setProduct(products);
			logger.info("Cart id will be getted ---->"+cart.getCartId());
			cartRepository.save(cart);
		}
		logger.info("|| CartServiceImpl end: added products to the cart ");

		return cart;

	}

	

	@Override
	public Cart updateProducts(Cart crt) {
		logger.info("|| CartServiceImpl end: Updating the products from the Cart ");
		Cart cart = cartRepository.findById(crt.getCartId())
				.orElseThrow(() -> new CartIdNotFoundException("Cart Id Not Found in the Data base"));
		if (cart.getQuantity() > 0) {
			int originalValue = cart.getQuantity();
			int subtract = originalValue - crt.getQuantity();

			cart.setQuantity(subtract);
			cartRepository.save(cart);
		} else if (cart.getQuantity() == 0) {
			cartRepository.delete(cart);
		}
		return cart;
	}

	@Override
	public void removeProducts(Integer cartId, Integer productId) {
		logger.info("|| CartServiceImpl entry : removeProducts from the cartId " + productId);
		Cart cart = cartRepository.findByCartId(cartId);
		if (cart == null) {
			throw new CartIdNotFoundException("Entered the cart number is not found in DB !!!");
		}
		List<Product> listOfProducts = cart.getProduct();
		for (int i = 0; i < listOfProducts.size(); i++) {
			Product product = listOfProducts.get(i);
			if (product.getProductId() == productId) {
				listOfProducts.remove(product);
				logger.error("|| CartServiceImpl  : productId : " + productId + " removed from cart ");
			}
		}

		logger.info("|| CartServiceImpl end : removeProducts from the cartId ");

	}

	@Override
	public void removeAllProducts(Integer cartId) {
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
//		List<Product> pd = productRepository.findByCart(cart);
		logger.info("|| CartServiceImpl  end: displayed all the product to cart");
		return cart;
	}

}