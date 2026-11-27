package main.easy;

import test.TestRunner;

/**
 * @see https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		return "";
	}

	@SuppressWarnings("java:S1172")
	public static void main(String[] args) {

		LongestCommonPrefix solution = new LongestCommonPrefix();

		String name = LongestCommonPrefix.class.getSimpleName();

		TestRunner.run(name, new String[] { "flower", "flow", "flight" }, "fl",
				() -> solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		
		TestRunner.run(name, new String[] {"dog","racecar","car"}, "",
				() -> solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));

		TestRunner.printSummary();
	}
}
