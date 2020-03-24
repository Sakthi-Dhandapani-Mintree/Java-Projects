package com.sakthi.without.optional;

public class DisplayFeatures {
	private String size;
	private ScreenResolution screen;

	public String getSize() {
		return size;
	}

	public ScreenResolution getScreen() {
		return screen;
	}

	public DisplayFeatures(String size, ScreenResolution screen) {
		this.size = size;
		this.screen = screen;
	}

}
