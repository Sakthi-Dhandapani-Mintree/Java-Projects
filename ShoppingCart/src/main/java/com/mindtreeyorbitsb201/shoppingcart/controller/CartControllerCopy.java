package com.mindtreeyorbitsb201.shoppingcart.controller;

import java.util.List;

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
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;
import com.mindtreeyorbitsb201.shoppingcart.service.CartService;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class CartControllerCopy {

	@Autowired
	private CartService cartService;

	@PostMapping(value = "/addproduct/{userId}/{productId}")
	public ResponseEntity<?> addProduct(@RequestBody Cart cart, @PathVariable Long productId,
			@PathVariable Long userId) {
		Cart carts = cartService.addProducts(cart, userId, productId);
		return new ResponseEntity<Cart>(carts, HttpStatus.OK);
	}

	/**
	 * Working fine
	 * 
	 * @param cartId
	 * @return
	 */
	@GetMapping(value = "/viewcart/{cartId}")
	public Cart viewCart(@PathVariable Long cartId) {
		Cart cart = cartService.viewProducts(cartId);
		return cart;
	}

	@DeleteMapping(value = "/delete/{cartId}/products/{productId}")
	public void deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
		cartService.removeProducts(cartId, productId);

	}

	@DeleteMapping(value = "/deleteall/{cartId}")
	public void deleteAllProductsFromCart(@PathVariable Long cartId) {
		cartService.removeAllProducts(cartId);

	}

	@PutMapping(value = "/updatecart")
	public Cart updateCart(@RequestBody Cart cart) {
		cartService.updateProducts(cart);
		return null;

	}
}
