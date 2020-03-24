package com.java8future.com;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicatExample3 {

	public static void main(String[] args) {
		String name = "Sakthi";
		Function<String,Integer> fun = n -> n.length();
		System.out.println(fun.apply(name));;
		}

}
