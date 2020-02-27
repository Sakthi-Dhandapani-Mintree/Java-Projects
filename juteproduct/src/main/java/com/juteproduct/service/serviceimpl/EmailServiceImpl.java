package com.juteproduct.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.ContactUs;
import com.juteproduct.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public String sendEmail(ContactUs contactUs) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(contactUs.getContactEmailAddress());
		simpleMailMessage.setSubject("Jute Site");
		simpleMailMessage.setText(contactUs.getContactMessageList());
		mailSender.send(simpleMailMessage);
		System.out.println("Mail Sent Succeffuly");
		return "Mail Sent Succeffuly";
	}

}
