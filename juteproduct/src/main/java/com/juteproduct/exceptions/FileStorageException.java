package com.juteproduct.exceptions;

import java.io.IOException;

public class FileStorageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg ;
	public FileStorageException(String msg) {
		this.msg = msg;
	}
	public FileStorageException(String string, IOException ex) {
	}
}
