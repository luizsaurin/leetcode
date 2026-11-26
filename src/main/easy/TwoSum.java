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

	public static void main() {
		TestRunner.twoSum(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 });
		TestRunner.twoSum(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 });
		TestRunner.twoSum(new int[] { 3, 3 }, 6, new int[] { 0, 1 });
	}
}
