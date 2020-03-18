package com.juteproduct.exceptions;

public class ProductNotFoundException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ProductNotFoundException(String name) {
		this.message = name;
	}
}
