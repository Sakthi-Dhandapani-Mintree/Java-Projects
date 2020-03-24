package com.sakthi.without.optional;

public class MobileService {
	public int getMobileService(Mobile mobile) {
		if (mobile != null) {
			DisplayFeatures df = mobile.getDisplay();
			if (df != null) {
				ScreenResolution sr = df.getScreen();
				if (sr != null) {
					return sr.getWidth();
				}
			}

		}
		return 0;
	}
}
