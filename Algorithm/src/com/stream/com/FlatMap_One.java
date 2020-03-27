package com.stream.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap_One {

	public static void main(String[] args) {
		List<Integer> primeNumbers = Arrays.asList(5,7,11,13);
		List<Integer> evenNumbers = Arrays.asList(2,8,4,8);
		List<Integer> oddNumbers = Arrays.asList(1,3,5);
		List<List<Integer>> entireList = Arrays.asList(primeNumbers,evenNumbers,oddNumbers);
		
		List<Integer> flattendMap = entireList.stream().flatMap(n ->n.stream()).collect(Collectors.toList());
		System.out.println(flattendMap);
	}

}
