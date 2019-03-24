package com.challenge.contest.leetcode.weekly129._1020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
	public boolean canThreePartsEqualSum(int[] A) {
		int sum = IntStream.of(A).sum();
		if ((sum % 3) != 0) {
			return false;
		}

		int expectedListSum = sum / 3;

		Arrays.parallelSort(A);
		List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>(), list3 = new ArrayList<>();
		int list1Sum = 0, list2Sum = 0, list3Sum = 0;

		for (int i = 0; i < A.length && A[i] < 0; i++) {
			if (list1Sum != expectedListSum && list1Sum + A[i] <= expectedListSum) {
				list1.add(i);
				list1Sum += A[i];
				i++;
			}
			if (list2Sum != expectedListSum && list2Sum + A[i] <= expectedListSum) {
				list2.add(i);
				list2Sum += A[i];
				i++;
			}
			if (list3Sum != expectedListSum && list3Sum + A[i] <= expectedListSum) {
				list3.add(i);
				list3Sum += A[i];
				i++;
			}

		}
		for (int i = A.length - 1; i >= 0;) {
			if (list1Sum != expectedListSum && list1Sum + A[i] <= expectedListSum) {
				list1.add(i);
				list1Sum += A[i];
				i--;
			}
			if (list2Sum != expectedListSum && list2Sum + A[i] <= expectedListSum) {
				list2.add(i);
				list2Sum += A[i];
				i--;
			}
			if (list3Sum != expectedListSum && list3Sum + A[i] <= expectedListSum) {
				list3.add(i);
				list3Sum += A[i];
				i--;
			}
		}
		if (list1Sum == expectedListSum && list2Sum == expectedListSum && list3Sum == expectedListSum)
			return true;
		else
			return false;
	}
}
