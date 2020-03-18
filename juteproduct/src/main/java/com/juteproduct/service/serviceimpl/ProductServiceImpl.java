package com.juteproduct.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.Product;
import com.juteproduct.exceptions.ProductNotFoundException;
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
	public void deleteProductByName(String productName) {
		List<Product> product = productRepository.findByProductName(productName);
		if (product != null) {
			for (Product p : product) {
				productRepository.deleteById(p.getProductId());
				System.out.println("Product " + p.getProductName() + " has been deleted");
			}
		} else {
			System.out.println("Product " + productName + " name not found !!!");
		}

	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Product updateProduct(Product product, Long productId) throws ProductNotFoundException {
		Product products = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product Not found for this ID" + productId));
		products.setProductName(product.getProductName());
		products.setProductPrice(product.getProductPrice());
		products.setProductSize(product.getProductSize());
		products.setProductType(product.getProductType());
		return productRepository.save(products);
	}

}
