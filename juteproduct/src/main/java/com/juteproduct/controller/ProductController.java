package com.juteproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@GetMapping(value = "/hello")
	public String getProduct() {
		return "Product Controller is Received";
	}
}
