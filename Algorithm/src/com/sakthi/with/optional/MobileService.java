package com.sakthi.with.optional;

import java.util.Optional;

public class MobileService {
	public Integer getMobileService(Optional<Mobile> mobile) {
		return mobile.flatMap(Mobile::getDisplay).flatMap(DisplayFeatures::getScreen).map(ScreenResolution::getWidth)
				.orElse(0);
	}
}
