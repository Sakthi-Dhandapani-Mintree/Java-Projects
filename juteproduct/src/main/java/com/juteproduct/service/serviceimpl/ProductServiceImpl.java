package com.juteproduct.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.Product;
import com.juteproduct.repository.ProductRepository;
import com.juteproduct.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> geProducts() {

		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(String productName) {
		Long productId = null;
		Product product = productRepository.findByProductName(productName);
		if (product != null) {
			productId = product.getProductId();
			productRepository.deleteById(productId);
			System.out.println("Product has been deleted");
		}

	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

}
