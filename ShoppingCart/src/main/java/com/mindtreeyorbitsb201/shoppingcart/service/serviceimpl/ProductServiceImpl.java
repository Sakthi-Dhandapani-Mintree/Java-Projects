package com.mindtreeyorbitsb201.shoppingcart.service.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtreeyorbitsb201.shoppingcart.controller.ProductController;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;
import com.mindtreeyorbitsb201.shoppingcart.exception.ProductNotFoundException;
import com.mindtreeyorbitsb201.shoppingcart.repository.ProductRepository;
import com.mindtreeyorbitsb201.shoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static Logger logger = LogManager.getLogger(ProductController.class);	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product searchProductById(Integer productId) {
		logger.info("|| ProductServiceImpl entry : searchProductById method : " +productId );
		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			logger.error(" || ProductServiceImpl :product is "+product);
			throw new ProductNotFoundException("Product Not found in DB with given Id : " + productId);
		}
		logger.info("|| ProductServiceImpl end : searchProductById method:");
		return product;
	}

	@Override
	public List<Product> searchProductByName(String productName) {
		logger.info("|| ProductServiceImpl entry : searchProductByName method : " +productName.toLowerCase() );
		List<Product> product = productRepository.findByProductName(productName.toLowerCase());
		if (product.isEmpty()) {
			logger.error(" || ProductServiceImpl :product size is empty "+product.size());
			throw new ProductNotFoundException("No product found in DB with given name : " + productName);
		}
		logger.info("|| ProductServiceImpl end : searchProductByName method: ");
		return product;
	}

	@Override
	public List<Product> searchProductByCategory(String productCategory) {
		logger.info("|| ProductServiceImpl entry : searchProductByName method : " +productCategory.toLowerCase() );
		List<Product> listOfProducts = productRepository.findByProductCategory(productCategory.toLowerCase());
		if (listOfProducts.isEmpty()) {
			logger.error(" || ProductServiceImpl :product size is empty "+listOfProducts.size());
			throw new ProductNotFoundException("No Product found in DB with given Category : " +productCategory);
		}
		logger.info("|| ProductServiceImpl end : searchProductByCategory method : ");
		return listOfProducts;
	}

}
