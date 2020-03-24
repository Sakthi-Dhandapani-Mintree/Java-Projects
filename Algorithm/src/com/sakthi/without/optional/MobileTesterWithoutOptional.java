package com.sakthi.without.optional;

public class MobileTesterWithoutOptional {

	public static void main(String[] args) {
		ScreenResolution sr = new ScreenResolution(750, 1334);
		DisplayFeatures df = new DisplayFeatures("4.7", sr);
		Mobile mb = new Mobile(1l, "Nokia", "1110", df);
		MobileService mbs = new MobileService();
		int value = mbs.getMobileService(mb);
		System.out.println("Apple iPhone 6s Screen Width = " + value);
	}

}
