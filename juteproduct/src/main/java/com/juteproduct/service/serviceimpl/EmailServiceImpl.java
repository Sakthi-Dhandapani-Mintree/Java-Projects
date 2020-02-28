package com.juteproduct.service.serviceimpl;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.ContactUs;
import com.juteproduct.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService {
	private static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * Send Email using javaMail Sender
	 */
	@Override
	public String sendEmail(ContactUs contactUs) {
		logger.info(":: Email Service Implemenation :: Send Mail ::");
		String stauts = "";
		try {
			stauts = sendEmailToCustomer(contactUs.getContactName(), contactUs.getContactEmailAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
		return stauts;
	}

	/**
	 * Send mail to customer for a acknowledgement
	 * 
	 * @param contactUs
	 */
	private String sendEmailToCustomer(String customerName, String customerEmailAddress) throws Exception {
		logger.info(":: Email Service Implemenation :: sendEmailToCustomer Successfully ::" + customerName + " "
				+ customerEmailAddress);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(customerEmailAddress);
		helper.setSubject("Haeron Jute Enterprise Enquirey");
		helper.setText("<html>" + "<body>" + "<h3>Hi " + customerName + "</h3>"
				+ "<p>Thank you so much for contucting to us. I've loved getting to know them and do business with them. I'm so happy that you've stuck around with us for this long and brought your friend to share the experience with you.\r\n"
				+ "\r\n" + "We're lucky to have you. Thanks again for being such a fantastic customer!</p>\r\n" + "\r\n"
				+ "<h3>Thanks & Regards," + "<h4>Sumathy Sakthi</h4>" + "</body>\r\n" + "</html>\r\n" + "", true);
		mailSender.send(mimeMessage);
		logger.info(":: Email Service Implemenation :: sendEmailToCustomer Successfully ::");
		return "Mail sent Successfully";
	}

}
