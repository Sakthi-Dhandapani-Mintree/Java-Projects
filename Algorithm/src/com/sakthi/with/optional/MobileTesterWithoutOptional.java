package com.sakthi.with.optional;

import java.util.Optional;

public class MobileTesterWithoutOptional {

	public static void main(String[] args) {
		ScreenResolution sr = new ScreenResolution(750, 1334);
		DisplayFeatures df = new DisplayFeatures("4.7", Optional.of(sr));
		Mobile mb = new Mobile(1l, "Nokia", "1110", Optional.of(df));
		MobileService mbs = new MobileService();
		int value = mbs.getMobileService(Optional.of(mb));
		System.out.println("Apple iPhone 6s Screen Width = " + value);
	}

}
