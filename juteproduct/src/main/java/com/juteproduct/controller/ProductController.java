package com.juteproduct.controller;

import java.util.List;

import javax.mail.Header;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juteproduct.entity.Product;
import com.juteproduct.exceptions.ProductNotFoundException;
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
	public ResponseEntity<?> addProdcut(@RequestBody Product product) {
		logger.debug("|==>" + " " + "addProdcut --" + " " + product.toString() + "<==|");
		Product products= iProductService.addProduct(product);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/addproduct")
				.buildAndExpand(products.getProductId()).toUri());
		return new ResponseEntity<>(products,httpHeaders,HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/deleteproductbyname/{productName}")
	public void deleteprodcutByName(@PathVariable String productName) {
		logger.debug("|==>" + " " + "deleteprodcutByName -- " + " " + productName + "<==|");
		iProductService.deleteProductByName(productName);
	}

	@PutMapping(value = "/update/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productId) throws ProductNotFoundException {
		logger.info("|==>" + " " + "UpdateprodcutById -- " + " " + productId + "<==|");
		Product updatedProduct = iProductService.updateProduct(product, productId);
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteproductbyid/{productId}")
	public void deleteprodcutById(@PathVariable Long productId) {
		logger.debug("|==>" + " " + "deleteprodcutById -- " + " " + productId + "<==|");
		iProductService.deleteProductById(productId);
	}

}
