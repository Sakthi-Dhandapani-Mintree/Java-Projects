package com.juteproduct.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	@PostMapping(value = "/upload")
	public ResponseEntity<FreeQuote> postAllFreeQuotas(@RequestParam("file") MultipartFile juteDocument,
			@RequestParam String juteDocId) throws IOException {
		freeQuoteService.uploadFile(juteDocument);
		return new ResponseEntity<FreeQuote>(HttpStatus.OK);

	}

	@PostMapping(value = "/uploads")
	public ResponseEntity<FreeQuote> uploadDocument(@RequestParam("file") MultipartFile juteDocument,
			@RequestParam String juteDocId) throws IOException {
		Path targetLocation = Paths
				.get("D:\\logs\\New folder1\\" + 1234 + File.separator + juteDocument.getOriginalFilename());
		return new ResponseEntity<FreeQuote>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<FreeQuote> uploadDocument() {
		String key = "12/69741379@N08.jpg";
		return new ResponseEntity<FreeQuote>(HttpStatus.OK);

	}

}
