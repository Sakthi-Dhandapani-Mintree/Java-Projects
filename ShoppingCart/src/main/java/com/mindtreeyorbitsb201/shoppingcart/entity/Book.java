package com.mindtreeyorbitsb201.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@PrimaryKeyJoinColumn(referencedColumnName = "productId")
public class Book extends Product {

	private static final long serialVersionUID = 1L;

	private String bookGenre;
	private String bookAuthour;
	private String bookPublications;

	public Book() {
	}

	public Book(int productId, String productName, String productCategory, float productPrice, String bookGenre,
			String bookAuthour, String bookPublications) {
		super(productId, productName, productCategory, productPrice);
		this.bookGenre = bookGenre;
		this.bookAuthour = bookAuthour;
		this.bookPublications = bookPublications;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookAuthour() {
		return bookAuthour;
	}

	public void setBookAuthour(String bookAuthour) {
		this.bookAuthour = bookAuthour;
	}

	public String getBookPublications() {
		return bookPublications;
	}

	public void setBookPublications(String bookPublications) {
		this.bookPublications = bookPublications;
	}

}
