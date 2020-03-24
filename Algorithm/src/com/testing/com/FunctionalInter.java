package com.testing.com;

@FunctionalInterface
interface Function{
	public String salary(String name);
}

public class FunctionalInter {

	public static void main(String[] args) {
		Function s = FunctionalInter::sayHello;
		String ss = s.salary("Sakthi");
		System.out.println(ss);
		
	}
	
	public static String sayHello(String name) {
		return "Hi "+name;
	}

}
