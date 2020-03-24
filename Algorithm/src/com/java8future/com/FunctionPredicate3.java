package com.java8future.com;

import java.util.function.Function;

public class FunctionPredicate3 {
	 
	public static Function<Employe,Employe> funcFirstName = emp -> {
		int pos = emp.getName().indexOf( " ");
		String newName = emp.getName().substring(0, pos);
		emp.setName(newName);
		return emp;
	};

}
