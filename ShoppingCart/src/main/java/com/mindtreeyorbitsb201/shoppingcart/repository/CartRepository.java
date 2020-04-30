package com.mindtreeyorbitsb201.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	Cart findByCartId(Integer cartId);
}
