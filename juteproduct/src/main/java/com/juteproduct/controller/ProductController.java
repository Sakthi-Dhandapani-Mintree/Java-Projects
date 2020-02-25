package com.juteproduct.controller;

import java.util.List;

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
	@Autowired
	private IProductService iProductService;

	@GetMapping(value = "/hello")
	public String getProduct() {
		return "Product Controller is Received";
	}

	@GetMapping(value = "getallproducts")
	public List<Product> getAllProdcuts() {
		return iProductService.geProducts();
	}

	@PostMapping(value = "addproduct")
	public Product addProdcut(@RequestBody Product product) {
		return iProductService.addProduct(product);

	}
	@DeleteMapping(value="deleteprodcut")
	public void deleteprodcut(@PathVariable String productName) {
		iProductService.deleteProduct(productName);
	}
	
}
