package com.java8future.com;

@FunctionalInterface
interface Mindtree {
	int getEmployeeId(int a,int b);
}
interface MyAdd{
	int add(int a,int b);
}

public class LambdaExpression_Test {

	public static void main(String[] args) {
		
		Mindtree myAdd = (int a,int b) -> a+b;
		System.out.println(myAdd);
	}

}
