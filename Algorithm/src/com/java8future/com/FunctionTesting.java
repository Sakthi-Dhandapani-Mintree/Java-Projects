package com.java8future.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTesting {

	public static void main(String[] args) {
		List<Employe> arraEmploye = Arrays.asList(new Employe("Sakhti Dandapani", 33),
				new Employe("Sumathy Sakthi", 31));
		List<Employe> res = convertListEmployee(arraEmploye, FunctionPredicate3.funcFirstName);
		res.forEach(System.out::println);

	}

	private static List<Employe> convertListEmployee(List<Employe> arraEmploye,
			Function<Employe, Employe> funcFirstName) {
		List<Employe> li = new ArrayList<Employe>();
		for (Employe e : arraEmploye) {
			li.add(funcFirstName.apply(e));
		}
		return li;
	}

}
