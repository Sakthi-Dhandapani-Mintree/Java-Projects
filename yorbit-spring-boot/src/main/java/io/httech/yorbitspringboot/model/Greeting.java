package io.httech.yorbitspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class Greeting {
	@Id
	@GeneratedValue
	private Long id;
	private String text;

	public Greeting(Long id, String text) {
		this.id = id;
		this.text = text;
	}

	public Greeting() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
