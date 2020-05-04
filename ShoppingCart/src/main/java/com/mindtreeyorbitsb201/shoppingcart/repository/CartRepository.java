package com.mindtreeyorbitsb201.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	Cart findByCartId(Integer cartId);
	Cart findByCartIdAndProduct(Integer cartId,Product product);
}
