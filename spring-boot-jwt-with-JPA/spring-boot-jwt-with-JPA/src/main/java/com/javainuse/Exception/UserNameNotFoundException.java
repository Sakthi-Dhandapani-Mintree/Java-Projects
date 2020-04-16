package com.javainuse.Exception;

public class UserNameNotFoundException extends Exception {
	private String string;

	public UserNameNotFoundException(String string) {
		this.string = string;
	}

}
