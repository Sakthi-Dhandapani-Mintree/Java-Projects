package com.java8future.com;

@FunctionalInterface
interface Collage {
	public int getID();
}

class CollageAdmin implements Collage {

	public int getID() {
		return 511;
	}

}

public class FunctionalInterface_Test {

	public static void main(String[] args) {
		Collage collage = new CollageAdmin();
		int i = collage.getID();
		System.out.println("------>" + i);
	}

}
