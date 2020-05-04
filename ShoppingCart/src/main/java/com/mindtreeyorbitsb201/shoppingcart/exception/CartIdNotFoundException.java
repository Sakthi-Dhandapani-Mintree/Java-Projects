package com.mindtreeyorbitsb201.shoppingcart.exception;

public class CartIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CartIdNotFoundException() {
		super();
	}
	public CartIdNotFoundException(String message) {
		super(message);
	}
	public CartIdNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
}
