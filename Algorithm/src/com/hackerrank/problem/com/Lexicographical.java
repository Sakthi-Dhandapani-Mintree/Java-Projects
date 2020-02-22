package com.hackerrank.problem.com;

public class Lexicographical {

	public static void main(String[] args) {
		String[] array = { "banana", "apple", "dollest", "cat" };
		for(int i =0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i].compareTo(array[j])>0) {
					String temp = array[i];
					array[i] =array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("After order!!!");
		for(int k = 0;k<array.length;k++) {
			System.out.println(array[k]);
		}
	}

}
