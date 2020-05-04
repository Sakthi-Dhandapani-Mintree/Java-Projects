package com.mindtreeyorbitsb201.shoppingcart.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtreeyorbitsb201.shoppingcart.entity.Product;
import com.mindtreeyorbitsb201.shoppingcart.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/search/products")
public class ProductController {
	private static Logger logger = LogManager.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/productid/{productId}")
	public ResponseEntity<Product> viewProductById(@PathVariable Integer productId) {
		logger.info("|| ProductController entry : viewProductById method : " + productId);
		Product product = productService.searchProductById(productId);
		logger.info("|| ProductController end : viewProductById method : ");
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/productname/{productName}")
	public ResponseEntity<List<Product>> viewProductByName(@PathVariable String productName) {
		logger.info("|| ProductController entry : viewProductByName method : " + productName);
		List<Product> product = productService.searchProductByName(productName);
		logger.info("|| ProductController end : viewProductByName method : ");
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/productcategory/{productCategory}")
	public ResponseEntity<List<Product>> viewProductByCategory(@PathVariable String productCategory) {
		logger.info("|| ProductController entry : viewProductByName method : " + productCategory);
		List<Product> product = productService.searchProductByCategory(productCategory);
		logger.info("|| ProductController end : viewProductByName method : ");
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
}
