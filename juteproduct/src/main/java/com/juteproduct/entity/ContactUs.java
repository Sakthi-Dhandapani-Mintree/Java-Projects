package com.juteproduct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contactus")
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contactid")
	private Integer contactId;
	@Column(name = "contactname")
	private String contactName;
	@Column(name = "contactemailaddress")
	private String contactEmailAddress;
	@Column(name = "contactphonenumber")
	private String contactPhoneNumber;
	@Column(name = "contactsubject")
	private String contactSubject;
	@Column(name = "contactmessages")
	private String contactMessages;

	public String getContactSubject() {
		return contactSubject;
	}

	public void setContactSubject(String contactSubject) {
		this.contactSubject = contactSubject;
	}

	public String getContactMessages() {
		return contactMessages;
	}

	public void setContactMessages(String contactMessages) {
		this.contactMessages = contactMessages;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	@Override
	public String toString() {
		return "ContactUs [contactId=" + contactId + ", contactName=" + contactName + ", contactEmailAddress="
				+ contactEmailAddress + ", contactPhoneNumber=" + contactPhoneNumber + ", contactMessageList="
				+ contactMessages + "]";
	}

}
