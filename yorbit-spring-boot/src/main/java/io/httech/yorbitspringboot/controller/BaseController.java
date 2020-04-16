package io.httech.yorbitspringboot.controller;

import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.httech.yorbitspringboot.web.DefaultExceptionalAtrributes;
import io.httech.yorbitspringboot.web.ExceptionalAtrributes;

public class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleException(Exception exception, HttpServletRequest httpRequest) {
		logger.error("> Handle Exception");
		logger.error(" >> Exception " + exception);
		ExceptionalAtrributes exceptionAttributes = new DefaultExceptionalAtrributes();
		Map<String, Object> responseBody = exceptionAttributes.getExceptionalAttributes(exception, httpRequest,
				HttpStatus.INTERNAL_SERVER_ERROR);
		logger.error("-->handledException");
		return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Map<String, Object>> handleNoResult(NoResultException noResultException, HttpServletRequest httpRequest) {
		logger.error("> Handle No Result");
		logger.error(" >> No-ResultException " + noResultException);
		ExceptionalAtrributes exceptionAttributes = new DefaultExceptionalAtrributes();
		Map<String, Object> responseBody = exceptionAttributes.getExceptionalAttributes(noResultException, httpRequest,
				HttpStatus.NOT_FOUND);
		logger.error("-->handledException");
		return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.NOT_FOUND);

	}

}
