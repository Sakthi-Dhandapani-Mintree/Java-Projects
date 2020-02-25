package com.juteproduct.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ContactUS")
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;
	private String contactName;
	private String contactEmailAddress;
	private String contactPhoneNumber;
	private String contactMessageList;

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

	public String getContactMessageList() {
		return contactMessageList;
	}

	public void setContactMessageList(String contactMessageList) {
		this.contactMessageList = contactMessageList;
	}

	@Override
	public String toString() {
		return "ContactUs [contactId=" + contactId + ", contactName=" + contactName + ", contactEmailAddress="
				+ contactEmailAddress + ", contactPhoneNumber=" + contactPhoneNumber + ", contactMessageList="
				+ contactMessageList + "]";
	}

}
