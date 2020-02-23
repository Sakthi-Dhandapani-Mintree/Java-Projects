package com.juteproduct.service;

import java.util.List;

import com.juteproduct.entity.Product;

public interface IProductService {
	List<Product> geProducts();
	void deleteProduct(Long productId);
	Product addProduct(Product product);
}
