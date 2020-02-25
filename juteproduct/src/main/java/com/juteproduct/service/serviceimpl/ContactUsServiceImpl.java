package com.juteproduct.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.ContactUs;
import com.juteproduct.repository.IContactUsRepository;
import com.juteproduct.service.IContactUsService;

@Service
public class ContactUsServiceImpl implements IContactUsService {

	@Autowired
	private IContactUsRepository iContactUsRepository;

	@Override
	public List<ContactUs> getAllContacts() {
		return iContactUsRepository.findAll();
	}

	@Override
	public ContactUs sendMail(ContactUs contactus) {
		return iContactUsRepository.save(contactus);
	}

	@Override
	public void deleteContacts(String phoneNumber) {
		ContactUs contactUs = iContactUsRepository.findByContactPhoneNumber(phoneNumber);
		if (contactUs != null) {
			iContactUsRepository.deleteById(contactUs.getContactId());
			System.out.println("Contact details has been deleted");
		}

	}

}
