package com.stream.com;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap_Two {

	public static void main(String[] args) {
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Stream<String[]> stringArray = Arrays.stream(array);
		Stream<String> flatedMapp = stringArray.flatMap(flat -> Arrays.stream(flat));
		Stream<String>finalvalue = flatedMapp.filter(x->"a".equals(x.toString()));
		finalvalue.forEach(System.out::println);
		System.out.println("Welcome");
		
	}

}
