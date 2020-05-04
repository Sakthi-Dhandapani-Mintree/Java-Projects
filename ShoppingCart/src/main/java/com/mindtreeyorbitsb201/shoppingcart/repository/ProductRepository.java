package com.mindtreeyorbitsb201.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByProductId(Integer productId);
	List<Product> findByProductIdAndCart(Integer cartId,Integer productId);
	List<Product> findByCart(Cart cartId);
	List<Product> findByProductName(String productName);
	List<Product> findByProductCategory(String productCategory);
}
