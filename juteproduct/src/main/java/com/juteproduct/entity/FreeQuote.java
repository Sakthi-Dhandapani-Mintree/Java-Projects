package com.juteproduct.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "freequote")
public class FreeQuote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "freequoteid")
	private Integer freequoteid;
	@Column(name = "freequotename")
	private String freequoteName;
	@Column(name = "freequoteemail")
	private String freequoteEmail;
	@Column(name = "freequotephone")
	private String freequotePhone;
	@Column(name = "freequoteproduct")
	private String freequoteProduct;
	@Column(name = "freequotequantity")
	private int freequoteQuantity;
	@Column(name = "freequoteimages")
	private Blob freequoteImages;
	@Column(name = "freequotemessage")
	private String freequoteMessage;

	public Integer getFreequoteid() {
		return freequoteid;
	}

	public void setFreequoteid(Integer freequoteid) {
		this.freequoteid = freequoteid;
	}

	public String getFreequoteName() {
		return freequoteName;
	}

	public void setFreequoteName(String freequoteName) {
		this.freequoteName = freequoteName;
	}

	public String getFreequoteEmail() {
		return freequoteEmail;
	}

	public void setFreequoteEmail(String freequoteEmail) {
		this.freequoteEmail = freequoteEmail;
	}

	public String getFreequotePhone() {
		return freequotePhone;
	}

	public void setFreequotePhone(String freequotePhone) {
		this.freequotePhone = freequotePhone;
	}

	public String getFreequoteProduct() {
		return freequoteProduct;
	}

	public void setFreequoteProduct(String freequoteProduct) {
		this.freequoteProduct = freequoteProduct;
	}

	public int getFreequoteQuantity() {
		return freequoteQuantity;
	}

	public void setFreequoteQuantity(int freequoteQuantity) {
		this.freequoteQuantity = freequoteQuantity;
	}

	public Blob getFreequoteImages() {
		return freequoteImages;
	}

	public void setFreequoteImages(Blob freequoteImages) {
		this.freequoteImages = freequoteImages;
	}

	public String getFreequoteMessage() {
		return freequoteMessage;
	}

	public void setFreequoteMessage(String freequoteMessage) {
		this.freequoteMessage = freequoteMessage;
	}

	@Override
	public String toString() {
		return "FreeQuote [freequoteid=" + freequoteid + ", freequoteName=" + freequoteName + ", freequoteEmail="
				+ freequoteEmail + ", freequotePhone=" + freequotePhone + ", freequoteProduct=" + freequoteProduct
				+ ", freequoteQuantity=" + freequoteQuantity + ", freequoteImages=" + freequoteImages
				+ ", freequoteMessage=" + freequoteMessage + "]";
	}

}
