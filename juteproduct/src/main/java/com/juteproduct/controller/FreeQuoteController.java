package com.juteproduct.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juteproduct.entity.FreeQuote;
import com.juteproduct.service.IFreeQuoteService;

@RestController
@RequestMapping(value = "/freequote")
public class FreeQuoteController {

	private Logger logging = LoggerFactory.getLogger(FreeQuoteController.class);

	@Autowired
	private IFreeQuoteService freeQuoteService;

	@GetMapping(value = "/getallquotes")
	public List<FreeQuote> getAllFreeQutes() {

		logging.debug("-->getAllFreeQutes<--");
		return freeQuoteService.getAllFreeQuote();
	}

	@PostMapping(value = "/postquery")
	public ResponseEntity<FreeQuote> postAllFreeQuotas(@RequestBody FreeQuote freeQuote) {
		System.out.println(freeQuote.toString());
		FreeQuote fq = freeQuoteService.addFreeQuotes(freeQuote);
		return new ResponseEntity<FreeQuote>(fq, HttpStatus.OK);

	}

}
