package com.sakthi.with.optional;

import java.util.Optional;

public class Mobile {
	private long id;
	private String brand;
	private String model;
	private Optional<DisplayFeatures> display;

	public Mobile(long id, String brand, String model, Optional<DisplayFeatures> display) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.display = display;
	}

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Optional<DisplayFeatures> getDisplay() {
		return display;
	}

}
