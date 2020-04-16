package com.java8future.com;

public class Testing {

	public static void main(String[] args) {

		System.out.println("Working");
		int[] test = { 3, 4, 5, 6, 7 };
		updateElement(test);

	}

	private static void updateElement(int[] array) {
		int sum = 0;
		if (array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}
			System.out.println(sum);
		}
		for (int k = 0; k < 100; k++) {
			int nv = updateElementDuplicate(k, array);
			if(nv > sum) {
				System.out.println("yes" +k);
				break;
			}
		}
		

	}

	private static int updateElementDuplicate(int k, int[] arr) {
		int summ = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = k;

		}
		for (int i = 0; i < arr.length; i++) {
			summ += arr[i];

		}
		return summ;
	}

}
