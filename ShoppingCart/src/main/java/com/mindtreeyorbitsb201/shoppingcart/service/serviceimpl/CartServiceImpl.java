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

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	private float totalAmount;

	private List<Product> products = null;

	@Override
	public Cart addProducts(Cart cart, Integer userId, Integer productId) {

		if (products == null) {
			products = new ArrayList<Product>();
		}
		logger.info("|| CartServiceImpl  entry: addProducts to user " + userId + " with product id is : " + productId);
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("Entered user not find in the DB !!!" + userId));

		cart.setUser(user);
		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductNotFoundException("Entered Product Id is not found in the DB :" + productId));

		Optional<Cart> carts = cartRepository.findById(cart.getCartId());

		if (!cartRepository.existsById(cart.getCartId()) && !cartRepository.existsById(cart.getUser().getId())) {
			logger.info("New user entered for shopping !!! ---->");
			products.clear();
			cart.setCartId(null);
			cart.setQuantity(0);
			cart.setTotalAmount(0.0f);
			cart.setProduct(null);
			totalAmount = 0.0f;

		}
		if (!carts.isPresent()) {
			products.add(product);
			totalAmount = totalAmount + product.getProductPrice();
			cart.setCartId(cart.getCartId());
			cart.setQuantity(products.size());
			cart.setTotalAmount(totalAmount);
			cart.setProduct(products);
			cartRepository.save(cart);
		} else {
			totalAmount = carts.get().getTotalAmount() + product.getProductPrice();
			cart.setQuantity(carts.get().getQuantity() + 1);
			cart.setCartId(cart.getCartId());
			cart.setTotalAmount(totalAmount);
			if (!products.contains(product)) {
				products.add(product);
			}
			cart.setProduct(products);
			cartRepository.save(cart);

		}
		logger.info("|| CartServiceImpl end: added products to the cart ");

		return cart;

	}

	@Override
	public Cart updateProducts(Cart cart) {
		logger.info("|| CartServiceImpl end: Updating the products from the Cart ");
		Cart dbCart = cartRepository.findById(cart.getCartId())
				.orElseThrow(() -> new CartIdNotFoundException("Cart Id Not Found in the Data base"));

		if (cart.getQuantity() > 0) {
			dbCart.setQuantity(cart.getQuantity());
			dbCart.setTotalAmount(getUpdatedAmount(dbCart.getProduct(), dbCart.getQuantity()));
			cartRepository.save(dbCart);
		} else if (cart.getQuantity() == 0) {
			dbCart.setCartId(cart.getCartId());
			dbCart.setQuantity(0);
			dbCart.setTotalAmount(0.0f);
			dbCart.setProduct(null);
			cartRepository.save(dbCart);
		}
		return dbCart;
	}

	/**
	 * This method used to update the amount based on the quantity
	 * 
	 * @param product
	 * @param quantity
	 * @return
	 */
	private float getUpdatedAmount(List<Product> product, int quantity) {
		float updatedAmount = 0.0f;
		for (int i = 0; i < product.size(); i++) {
			updatedAmount = quantity * product.get(i).getProductPrice();
		}
		return updatedAmount;
	}

	@Override
	public Cart removeProducts(Integer cartId, Integer productId) {
		boolean isProductDeleted = false;
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
				isProductDeleted = true;
				logger.error("|| CartServiceImpl  : productId : " + productId + " removed from cart ");
			}
		}
		if (listOfProducts.size() > 0) {
			for (int i = 0; i < listOfProducts.size(); i++) {
				Product product = listOfProducts.get(i);
				if (product != null) {
					cart.setCartId(cartId);
					cart.setProduct(listOfProducts);
					cart.setQuantity(cart.getQuantity());
					cart.setTotalAmount(cart.getQuantity() * product.getProductPrice());
					logger.error("|| CartServiceImpl  : productId : " + productId + " removed from cart ");
				}
			}
		}
		if (listOfProducts.size() == 0) {
			cart.setCartId(cartId);
			cart.setProduct(listOfProducts);
			cart.setQuantity(listOfProducts.size());
			cart.setTotalAmount(0.0f);
		}

		if (!isProductDeleted) {
			throw new ProductNotFoundException("Given product Id : " + productId
					+ "is not associated with given cart Id " + cartId + " / or not found");
		}

		logger.info("|| CartServiceImpl end : removeProducts from the cartId ");
		return cart;

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
		logger.info("|| CartServiceImpl  end: displayed all the product to cart");
		return cart;
	}

}