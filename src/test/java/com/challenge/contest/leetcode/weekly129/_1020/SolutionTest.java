package com.challenge.contest.leetcode.weekly129._1020;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void testBasic() {
		int[] input = new int[] { 1, 1, 1 };
		Solution solution = new Solution();
		Assert.assertTrue(solution.canThreePartsEqualSum(input));
	}

	@Test
	public void testBasicFalse() {
		int[] input = new int[] { 1, 2, 1 };
		Solution solution = new Solution();
		Assert.assertFalse(solution.canThreePartsEqualSum(input));
	}

}
