package com.juteproduct.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juteproduct.entity.ContactUs;
import com.juteproduct.service.IContactUsService;
import com.juteproduct.service.IEmailService;
import com.juteproduct.service.serviceimpl.EmailServiceImpl;

@RestController
@RequestMapping(value = "/sendemail")
public class SendEmailController {
private static Logger logger = Logger.getLogger(SendEmailController.class);
	@Autowired
	private IContactUsService iContactUsService;
	

	@PostMapping(value = "/email")
	public String sendEmail(@RequestBody ContactUs contactDetails) {
		logger.info("|===> sendEmail Method Ivoked <==|");
		iContactUsService.sendMail(contactDetails);		
		return "Email Sent successfully";
	}
	
	@GetMapping(value = "/getall")
	public List<ContactUs> getAllContacts() {
		logger.info("|===> sendEmail getAllContacts Ivoked <==|");
		List<ContactUs> listofContacts = iContactUsService.getAllContacts();
		return listofContacts;
	}
	
}
