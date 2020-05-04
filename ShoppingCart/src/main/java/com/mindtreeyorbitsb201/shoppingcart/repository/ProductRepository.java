package com.mindtreeyorbitsb201.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByProductId(Long productId);
	List<Product> findByProductIdAndCart(Long cartId,long productId);
	List<Product> findByCart(Cart cartId);

	Product findByProductName(String productName);
}
