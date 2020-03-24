package com.java8future.com;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {
	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	public static Predicate<Employee> isAdultFemale() {
		return f -> f.getAge() > 18 && f.getGender().equalsIgnoreCase("F");
	}

	public static Predicate<Employee> isAgeMoreThan(Integer age) {
		return a -> a.getAge() > age;
	}

	
	public static Predicate<Employee> isFirstNameLastName(){
		return  v -> v.getFirstName().length() + v.getLastName().length() > 20;
	}

	public static List<Employee> filterEmployee(List<Employee> employees, Predicate<Employee> predicate) {
		
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}
}
