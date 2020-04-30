package com.mindtreeyorbitsb201.shoppingcart.controller;

import java.util.Collection;

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
public class CartController {

	@Autowired
	private CartService cartService;

	/**
	 * It is working as of now 
	 * @param cart
	 * @param productId
	 * @param userId
	 * @return
	 */
	@PostMapping(value = "/addcart/{productId}/{userId}")
	public ResponseEntity<?> addCart(@RequestBody Cart cart, @PathVariable Integer productId,
			@PathVariable Integer userId) {
		Cart carts = cartService.addProducts(cart, productId, userId);
		return new ResponseEntity<Cart>(carts, HttpStatus.OK);
	}

	/**
	 * Not Working as of now
	 * 
	 * @param cartId
	 * @return
	 */
	@GetMapping(value = "/viewcart/{cartId}")
	public Cart viewCart(@PathVariable Integer cartId) {
		Cart cart = cartService.viewProducts(cartId);
		return cart;
	}

	@DeleteMapping(value = "/delete/{cartId}/products/{productId}")
	public void deleteProductFromCart(@PathVariable Integer cartId, @PathVariable Integer productId) {
		cartService.removeProducts(cartId, productId);

	}
	@PutMapping(value="/updatecart")
	public Cart updateCart(@RequestBody Cart cart) {
		cartService.updateProducts(cart);
		return null;
		
	}
}
