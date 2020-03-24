package com.sakthi.with.optional;

import java.util.Optional;

public class DisplayFeatures {
	private String size;
	private Optional<ScreenResolution> screen;

	public String getSize() {
		return size;
	}

	public Optional<ScreenResolution> getScreen() {
		return screen;
	}

	public DisplayFeatures(String size, Optional<ScreenResolution> screen) {
		this.size = size;
		this.screen = screen;
	}

}
