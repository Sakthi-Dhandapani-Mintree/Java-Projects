package com.java8optional.example;

import java.util.Optional;

public class Optional_2 {

	public static void main(String[] args) {
		Optional<String> opt = Optional.of("SAKTHI");
		if (opt.isPresent()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		opt.ifPresent(s -> System.out.println(s.toLowerCase()));
		
		Optional<String> optt = Optional.of("MALE");
		Optional<String> opem = Optional.empty();
		System.out.println(optt.orElse("N/A"));//MALE
		System.out.println(opem.orElse("N/A"));//N/A
		System.out.println(optt.orElseGet(()->"MALE"));//MALE
		System.out.println(opem.orElseGet(()->"N/M")); //n/a
		
	}

}
