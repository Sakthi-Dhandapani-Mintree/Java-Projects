package com.problems.com;

import java.io.IOException;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author M1048135
 *
 */
public class AddSum {

	public static void main(String[] args) throws IOException {
		AddSum addSum = new AddSum();
		int[] input = { 2, 7, 11, 15 };
		int targetSum = 17;
		int[] result = addSum.twoSum(input, targetSum);
		for (int a : result) {
			System.out.print(" " + a);
		}
	}

	public int[] twoSum(int[] nums, int target) throws IOException {
		boolean updated = false;
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					ans[0] = i;
					ans[1] = j;
					updated = true;
				}

			}
		}
		if (!updated) {
			throw new IOException("Target value is not present");
		}
		return ans;
	}
}
