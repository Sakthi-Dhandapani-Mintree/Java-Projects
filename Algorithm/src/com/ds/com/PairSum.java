package com.ds.com;

import java.util.Scanner;

public class PairSum {

	public static void main(String[] args) {
		int[] array = { 8, 7, 2, 5, 3, 1 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Sum value ");
		int sum = sc.nextInt();
		PairSum p = new PairSum();
		p.findPairSum(array, sum);
	}

	public void findPairSum(int[] array, int sum) {
		int positionOne = 0;
		int positionTwo = 0;

		System.out.println("Printing the current array ");
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i; j < array.length; j++) {
				if (sum == array[i] + array[j]) {
					positionOne = i;
					positionTwo = j;
					if (positionOne != positionTwo)
						System.out.println("positionOne   " + positionOne + "  positionTwo    " + positionTwo);
				}
			}

		}

	}

}
