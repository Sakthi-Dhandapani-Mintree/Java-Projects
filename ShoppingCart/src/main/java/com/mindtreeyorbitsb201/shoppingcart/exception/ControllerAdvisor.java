package com.mindtreeyorbitsb201.shoppingcart.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProducutNotFoundException(ProductNotFoundException productNotFoundException,
			WebRequest webRequest) {
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("Timesstamp", LocalDateTime.now());
		body.put("message", productNotFoundException.getMessage());
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CartIdNotFoundException.class)
	public ResponseEntity<Object> handleCartIdNotFoundException(CartIdNotFoundException cartIdNotFoundException,
			WebRequest webRequest) {
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("Timesstamp", LocalDateTime.now());
		body.put("message", cartIdNotFoundException.getMessage());
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException,
			WebRequest webRequest) {
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("Timesstamp", LocalDateTime.now());
		body.put("message", userNotFoundException.getMessage());
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}

}
