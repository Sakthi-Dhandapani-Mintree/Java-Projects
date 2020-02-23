package com.juteproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juteproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findProductName(String productName);
}
