package com.java8optional.example;

import java.util.Optional;

public class Optional_1 {

	public static void main(String[] args) {
		Optional<String> opt = Optional.empty();
		String val = null;
		System.out.println("---->"+Optional.ofNullable(val));
		if(opt.isPresent()) {
			System.out.println("opt value present");
		}else {
			System.out.println("opt No value present");
		}
		 
		Optional<String> optValue = Optional.of("Sakhti");
		System.out.println(optValue.map(String::toUpperCase));
		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("Sakthi-1"));
		if(nonEmptyOtionalGender.isPresent()){
			System.out.println(nonEmptyOtionalGender.get());
		}
		System.out.println(nonEmptyOtionalGender.map(t ->t.map(String::toLowerCase)));
		System.out.println(nonEmptyOtionalGender.flatMap(st ->st.map(String::toUpperCase)));
		if(optValue.isPresent()) {
			System.out.println(optValue.get());
		}
	}

}
