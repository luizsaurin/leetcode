package main.easy;

import java.util.HashMap;
import java.util.Map;

import test.TestRunner;

/**
 * @see https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (seen.containsKey(complement)) {
				return new int[] { seen.get(complement), i };
			}

			seen.put(nums[i], i);
		}

		return new int[] {};
	}

	@SuppressWarnings("java:S1172")
	public static void main(String[] args) {

		TwoSum solution = new TwoSum();

		String name = TwoSum.class.getSimpleName();

		TestRunner.run(
				name,
				"nums=" + java.util.Arrays.toString(new int[] { 2, 7, 11, 15 }) + ", target=9",
				new int[] { 0, 1 },
				solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));

		TestRunner.run(
				name,
				"nums=[3, 2, 4], target=6",
				new int[] { 1, 2 },
				solution.twoSum(new int[] { 3, 2, 4 }, 6));

		TestRunner.run(
				name,
				"nums=[3, 3], target=6",
				new int[] { 0, 1 },
				solution.twoSum(new int[] { 3, 3 }, 6));
	}
}