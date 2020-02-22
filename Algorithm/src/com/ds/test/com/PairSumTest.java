package com.ds.test.com;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.ds.com.PairSum;

class PairSumTest {
	private PairSum p;
	@Before
	public void initilize() {
		 p = new PairSum();
	}

	@Test
	void test() {
		int[] array = { 8, 7, 2, 5, 3, 1 };
		p.findPairSum(array,10);
	}

}
