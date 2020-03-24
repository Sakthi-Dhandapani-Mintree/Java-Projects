package com.sakthi.without.optional;

public class Mobile {
	private long id;
	private String brand;
	private String model;
	private DisplayFeatures display;

	public Mobile(long id, String brand, String model, DisplayFeatures display) {
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

	public DisplayFeatures getDisplay() {
		return display;
	}

}
