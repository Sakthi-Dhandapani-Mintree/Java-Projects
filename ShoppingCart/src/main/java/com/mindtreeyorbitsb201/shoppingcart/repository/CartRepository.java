package com.mindtreeyorbitsb201.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByCartId(Long cartId);
}
