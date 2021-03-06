package com.juteproduct.service.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.ContactUs;
import com.juteproduct.repository.IContactUsRepository;
import com.juteproduct.service.IContactUsService;
import com.juteproduct.service.IEmailService;

@Service
public class ContactUsServiceImpl implements IContactUsService {
	private static final Logger logger = LogManager.getLogger(ContactUsServiceImpl.class);
	@Autowired
	private IContactUsRepository iContactUsRepository;

	@Autowired
	private IEmailService iEmailService;

	@Override
	public List<ContactUs> getAllContacts() {
		logger.info("|==> sendMail getAllContacts Invoked <==| ");
		return iContactUsRepository.findAll();
	}

	@Override
	public ContactUs sendMail(ContactUs contactus) {
		logger.info(":: ContactutUs Service Implemenation :: Send Mail ::");
		iEmailService.sendEmail(contactus);

		ContactUs contactUs = iContactUsRepository.save(contactus);
		if (contactUs != null) {
			logger.info(":: ContactutUs Service Implemenation :: Customer details saved into DB Successfully ::");
		}
		return contactUs;
	}

	@Override
	public void deleteContacts(String phoneNumber) {
		ContactUs contactUs = iContactUsRepository.findByContactPhoneNumber(phoneNumber);
		if (contactUs != null) {
//			iContactUsRepository.deleteById(contactUs.getContactId());
			System.out.println("Contact details has been deleted");
		}

	}

}
