package io.httech.yorbitspringboot.web;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public class DefaultExceptionalAtrributes implements ExceptionalAtrributes {
	public static final String TIMESTAMP = "timestamp";
	public static final String STATUS = "status";
	public static final String ERROR = "error";
	public static final String EXCEPTION = "exception";
	public static final String MESSAGE = "message";
	public static final String PATH = "path";

	@Override
	public Map<String, Object> getExceptionalAttributes(Exception exceptions, HttpServletRequest httpRequest,
			HttpStatus httpStatus) {

		Map<String, Object> exceptionAttriubest = new LinkedHashMap<>();
		exceptionAttriubest.put(TIMESTAMP, new Date());
		addHttpStatus(exceptionAttriubest, httpStatus);

		addExceptionalDetails(exceptionAttriubest, exceptions);
		addPath(exceptionAttriubest, httpRequest);
		return exceptionAttriubest;
	}

	private void addHttpStatus(Map<String, Object> exceptionalAttributes, HttpStatus httpStatus) {
		exceptionalAttributes.put(STATUS, httpStatus.value());
		exceptionalAttributes.put(ERROR, httpStatus.getReasonPhrase());
	}

	private void addExceptionalDetails(Map<String, Object> exceptionalAttributes, Exception exception) {
		exceptionalAttributes.put(EXCEPTION, exception.getClass().getName());
		exceptionalAttributes.put(MESSAGE, exception.getMessage());
	}

	private void addPath(Map<String, Object> exceptionalAttributes, HttpServletRequest httpRequest) {
		exceptionalAttributes.put(PATH, httpRequest.getServletPath());

	}

}
