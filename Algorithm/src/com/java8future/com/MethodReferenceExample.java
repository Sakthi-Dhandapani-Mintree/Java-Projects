package com.java8future.com;

import java.util.Arrays;
import java.util.stream.Stream;

public class MethodReferenceExample {

	public static void main(String[] args) {
		String[] nameArray = { "Barbara", "Apple", "Mary", "John", "Robert", "Micheal", "Linda", "james", "mary" };
		Arrays.sort(nameArray,String::compareToIgnoreCase);
		Arrays.asList(nameArray).forEach(System.out::print);
		System.out.println("***");
		Stream.of(nameArray).forEach(System.out::print);
		
	}

}
