package com.mindtreeyorbitsb201.shoppingcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeyorbitsb201.shoppingcart.entity.Cart;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByProductId(Integer productId);
//	Optional<Cart> findByProductIdAndCart(Integer productId,Cart cart);
//	List<Product> findByCart(Cart cartId);
	List<Product> findByProductName(String productName);
	List<Product> findByProductCategory(String productCategory);
}
