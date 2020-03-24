package com.ds.com;

public class AddTwoNumberWithoutOperator {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		int c = add(a,b);
		System.out.println(c);

	}

	private static int add(int a, int b) {
		System.out.println(-(-b));
		return a -(-b);
	}

}
