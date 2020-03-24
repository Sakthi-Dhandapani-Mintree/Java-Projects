package com.testing.com;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("a", "a");
		hashMap.put(null, "a");
		hashMap.put(null, null);
		hashMap.put(null, null);
		hashMap.put("b", "a");
		hashMap.put("c", "a");

		for (Map.Entry<String, String> s : hashMap.entrySet()) {
			System.out.println(s.getKey());
		}

	}

	static String catAndMouse(int x, int y, int z) {
		String value = "";
		int a = Math.abs(x - z);
		int b = Math.abs(y - z);
		if (a == b)
			value = "Mouse C";
		if (a < b)
			value = "Cat A";
		if (a > b)
			value = "Cat B";
		return value;
	}
}
