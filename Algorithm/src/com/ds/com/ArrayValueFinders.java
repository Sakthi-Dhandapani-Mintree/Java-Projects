package com.ds.com;

public class ArrayValueFinders {

	public static void main(String[] args) {
		int[] array = { 3, 0, 4, 1, 2 };
//		int[] array = { 2, 1 };
		//5,2,4,1,3,
		//1,0,3,4,2,
		boolean value = validate(array);
		if (value) {
			printArrayPosition(array);
		}

	}

	private static boolean validate(int[] array) {
		boolean value = true;
		if (array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				if (array.length < array[i]) {
					System.out.println(array[i]);
					value = false;
				}
			}
		}
		return value;

	}

	public static void printArrayPosition(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			if(value <array.length) {
				int exactValue = array[value];
				int exactValue1 = array[exactValue];
				System.out.println(exactValue1);
			}
			

		}

	}

}