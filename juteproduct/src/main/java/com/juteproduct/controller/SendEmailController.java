package com.juteproduct.controller;

import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juteproduct.entity.ContactUs;
import com.juteproduct.service.IContactUsService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/sendemail")
public class SendEmailController {
	private static Logger logger = Logger.getLogger(SendEmailController.class);
	@Autowired
	private IContactUsService iContactUsService;

	@PostMapping(value = "/email")

	public String sendEmail(@RequestBody ContactUs contactDetails) {
//		generateRandomNumber(contactDetails);
		boolean value = false;
		logger.info("Assign the Random number to Customer for future reference." + contactDetails.getContactId());
		logger.info("Send Email Controller:: SendEmail ::" + contactDetails.toString());
		try {
			ContactUs contact = iContactUsService.sendMail(contactDetails);
			if (contact != null) {
				value = true;
			}

			if (value) {
				return new ObjectMapper().writeValueAsString("Success");
			} else {
				return new ObjectMapper().writeValueAsString("Failed");
			}

		} catch (JsonParseException e) {
			logger.info("JsonParseException" + e);

		} catch (JsonMappingException e) {
			logger.info("JsonMappingException" + e);
		} catch (IOException e) {
			logger.info("IOException :" + e);
		}
		logger.info("addResource method completed");

		return "";
	}

	@GetMapping(value = "/getall")
	public List<ContactUs> getAllContacts() {
		logger.info("::Send Email Controller:: GetAllEmailContacts :: <==|");
		List<ContactUs> listofContacts = iContactUsService.getAllContacts();
		return listofContacts;
	}

	
}
