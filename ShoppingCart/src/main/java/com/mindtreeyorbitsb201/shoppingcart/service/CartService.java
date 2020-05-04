package com.mindtreeyorbitsb201.shoppingcart.service;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;

public interface CartService {
	Cart addProducts(Cart cart,Long userId,Long productId);
	Cart updateProducts(Cart cart);
	void removeProducts(Long cartId,Long productId);
	void removeAllProducts(Long cartId);
	Cart viewProducts(Long userId);
	
}
