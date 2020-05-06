package com.mindtreeyorbitsb201.shoppingcart.service;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;

public interface CartService {
	Cart addProducts(Cart cart,Integer userId,Integer productId);
	Cart updateProducts(Cart cart);
	Cart removeProducts(Integer cartId,Integer productId);
	void removeAllProducts(Integer cartId);
	Cart viewProducts(Integer userId);
	
}
