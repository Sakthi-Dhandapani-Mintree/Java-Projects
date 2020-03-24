package com.java8future.com;

import java.util.function.Predicate;

public class PostiveNumberPredicate {

	public static Predicate<Integer> postiveNumberPredicate = t -> t > 0;
	public static Predicate<Integer> nagativeNumberPredicate = t -> t < 0;

	public static Predicate<Integer> getSepcificNumber(Integer arg) {
		return t -> t == arg;
	}

}
