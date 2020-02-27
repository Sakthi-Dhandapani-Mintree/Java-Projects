package com.juteproduct.service;

import java.util.List;

import com.juteproduct.entity.Product;

public interface IProductService {
	List<Product> geProducts();
	void deleteProductByName(String productId);
	void deleteProductById(Long productId);
	Product addProduct(Product product);
}
