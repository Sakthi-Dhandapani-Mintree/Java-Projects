package com.java8future.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static com.java8future.com.EmployeePredicates.*;

public class PredicateExample2 {
	/**
	 * It is used to Predicate accept one parameter and return as boolean.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> integerValues = Arrays.asList(new Integer[] {0,1,-2,-4,8,9});
		List<Integer> result = getPostiveNumber(integerValues,PostiveNumberPredicate.getSepcificNumber(8).or(PostiveNumberPredicate.nagativeNumberPredicate).negate());
		result.forEach(System.out::println);
	}

	private static List<Integer> getPostiveNumber(List<Integer> postiveValueas, Predicate<Integer> postiveNumberPredicate) {
		List<Integer> returnPostive = new ArrayList<Integer>();
		for(int i :postiveValueas) {
			if(postiveNumberPredicate.test(i)) {
				returnPostive.add(i);
			}
			
		}
		return returnPostive;
	}

}
