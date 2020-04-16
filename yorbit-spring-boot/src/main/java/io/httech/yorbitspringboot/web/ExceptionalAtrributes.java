package io.httech.yorbitspringboot.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public interface ExceptionalAtrributes {
Map<String, Object> getExceptionalAttributes(Exception exceptions,HttpServletRequest httpRequest,HttpStatus httpResonse);
}
