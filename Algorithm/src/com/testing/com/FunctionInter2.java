package com.testing.com;

@FunctionalInterface
interface AgeCompare {
	public int ageCompare(int age1, int age2);
}

public class FunctionInter2 {

	public static void main(String[] args) {
		System.out.println("We are going to compare Age");
		AgeCompare ageCompare = FunctionInter2::compare;
		AgeCompare agcompare = (a,b) ->{
			return b-a;
		};
		System.out.println(agcompare.ageCompare(4, 7));
		System.out.println(ageCompare.ageCompare(2, 9));
	}

	private static int compare(int one, int two) {
		return two - one;
	}

}
