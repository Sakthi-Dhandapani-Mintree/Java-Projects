package com.juteproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juteproduct.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByProductName(String productName);
}
