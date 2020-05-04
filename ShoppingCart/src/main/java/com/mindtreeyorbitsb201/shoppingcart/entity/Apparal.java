package com.mindtreeyorbitsb201.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "apparal")
@PrimaryKeyJoinColumn(referencedColumnName = "productId")
public class Apparal extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String apparalType;
	private String apparalBrand;
	private String apparalDesign;

	public Apparal() {
	}

	public Apparal(int productId, String productName, String productCategory, float productPrice, String apparalType,
			String apparalBrand, String apparalDesign) {
		super(productId, productName, productCategory, productPrice);
		this.apparalType = apparalType;
		this.apparalBrand = apparalBrand;
		this.apparalDesign = apparalDesign;
	}

	public String getApparalType() {
		return apparalType;
	}

	public void setApparalType(String apparalType) {
		this.apparalType = apparalType;
	}

	public String getApparalBrand() {
		return apparalBrand;
	}

	public void setApparalBrand(String apparalBrand) {
		this.apparalBrand = apparalBrand;
	}

	public String getApparalDesign() {
		return apparalDesign;
	}

	public void setApparalDesign(String apparalDesign) {
		this.apparalDesign = apparalDesign;
	}

}
