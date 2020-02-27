package com.juteproduct.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juteproduct.entity.Product;
import com.juteproduct.service.IProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	@Autowired
	private IProductService iProductService;
	
	@GetMapping(value = "/getallproducts")
	public List<Product> getAllProdcuts() {
		return iProductService.geProducts();
	}

	@PostMapping(value = "/addproduct")
	public Product addProdcut(@RequestBody Product product) {
		logger.debug("|==>" + " " + "addProdcut --" + " " + product.toString() + "<==|");
		return iProductService.addProduct(product);

	}

	@DeleteMapping(value = "/deleteproductbyname/{productName}")
	public void deleteprodcutByName(@PathVariable String productName) {
		logger.debug("|==>" + " " + "deleteprodcutByName -- " + " " + productName + "<==|");
		iProductService.deleteProductByName(productName);
	}

	@DeleteMapping(value = "/deleteproductbyid/{productId}")
	public void deleteprodcutById(@PathVariable Long productId) {
		logger.debug("|==>" + " " + "deleteprodcutById -- " + " " + productId + "<==|");
		iProductService.deleteProductById(productId);
	}

}
