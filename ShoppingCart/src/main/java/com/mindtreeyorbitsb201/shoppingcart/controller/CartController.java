package com.mindtreeyorbitsb201.shoppingcart.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.service.CartService;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class CartController {
	private static Logger logger = LogManager.getLogger(CartController.class);
	@Autowired
	private CartService cartService;

	@PostMapping(value = "/addproduct/{userId}/{productId}")
	public ResponseEntity<?> addProduct(@RequestBody Cart cart, @PathVariable Integer userId,
			@PathVariable Integer productId) {
		logger.info(
				"|| Cart Controller Begin : AddProduct method : " + cart.toString() + " " + userId + " " + productId);
		Cart carts = cartService.addProducts(cart, userId, productId);
		logger.info("|| Cart Controller End : AddProduct Method");
		return new ResponseEntity<Cart>(carts, HttpStatus.OK);
	}

	@GetMapping(value = "/viewcart/{cartId}")
	public Cart viewCart(@PathVariable Integer cartId) {
		logger.info("|| Cart Controller entry : viewCart method : " + cartId);
		Cart cart = cartService.viewProducts(cartId);
		logger.info("|| Cart Controller End : viewCart Method");
		return cart;
	}

	@PutMapping(value = "/updatecart}")
	public Cart updateCart(@RequestBody Cart cart) {
		logger.info("|| Cart Controller entry : updateCart method : " + cart.toString());
		Cart updatedCart = cartService.updateProducts(cart);
		logger.info("|| Cart Controller end : updated cart");
		return updatedCart;

	}

	@DeleteMapping(value = "/delete/{cartId}/products/{productId}")
	public void deleteProductFromCart(@PathVariable Integer cartId, @PathVariable Integer productId) {
		logger.info("|| Cart Controller entry : deleteProductFromCart method : " + productId);
		cartService.removeProducts(cartId, productId);
		logger.info("|| Cart Controller end : deleteProductFromCart method : ");

	}

	@DeleteMapping(value = "/deleteall/{cartId}")
	public void deleteAllProductsFromCart(@PathVariable Integer cartId) {
		logger.info("|| Cart Controller entry : deleteAllProductsFromCart method : " + cartId);
		cartService.removeAllProducts(cartId);
		logger.info("|| Cart Controller entry : deleteAllProductsFromCart method : ");
	}
}
