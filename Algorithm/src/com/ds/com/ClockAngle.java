package com.ds.com;

public class ClockAngle {

	public static void main(String[] args) {
		int h = 5;
		int m = 30;
		System.out.println(findAngle(h, m));
	}

	private static int findAngle(int h, int m) {
		int hDegree = (h * 360) / 12 + (m * 360) / (12 * 60);
		int mDegree = (m * 360) / (60);
		int angle = Math.abs(hDegree - mDegree);
		if (angle > 180) {
			angle = 360 - angle;
		}
		return angle;
	}

}
