package com.juteproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juteproduct.entity.ContactUs;
import com.juteproduct.service.IContactUsService;

@RestController
@RequestMapping(value = "sendemail")
public class SendEmailController {

	@Autowired
	private IContactUsService iContactUsService;

	@PostMapping(value = "email")
	public String sendEmail(@RequestBody ContactUs contactDetails) {
		iContactUsService.sendMail(contactDetails);
		return "Email Sent successfully";
	}
	
}
