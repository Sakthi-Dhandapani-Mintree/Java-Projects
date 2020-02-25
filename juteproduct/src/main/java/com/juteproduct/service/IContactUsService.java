package com.juteproduct.service;

import java.util.List;

import com.juteproduct.entity.ContactUs;

public interface IContactUsService {
	List<ContactUs> getAllContacts();
	ContactUs sendMail(ContactUs contactUs);
	void deleteContacts(String phoneNumber);
}
