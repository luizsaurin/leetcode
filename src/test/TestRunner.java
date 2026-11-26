package test;

import main.easy.IsPalindrome;
import main.easy.RomanToInteger;
import main.easy.TwoSum;

@SuppressWarnings({"java:S1118", "java:S106"})
public class TestRunner {

	private static void printResult(boolean result, Object input, Object output, Object expected) {

		StringBuilder sb = new StringBuilder();

		sb.append("[")
			.append((result) ? "\u001B[32m" : "\u001B[31m")
			.append((result) ? "PASSED" : "FAILED")
			.append("\u001B[0m")
			.append("] ")
			.append("Input: ")
			.append(input)
			.append(" Output: ")
			.append(output)
			.append(" -> Expected: ")
			.append(expected);

		System.out.println(sb.toString());

	}

	public static void twoSum(int[] input, int target, int[] expected) {
		TwoSum solution = new TwoSum();

		int[] output = solution.twoSum(input, target);

		boolean result = output == expected;
	
		printResult(result, input, output, expected);
	}

	public static void isPalindrome(int input, boolean expected) {
		IsPalindrome solution = new IsPalindrome();
		
		boolean output = solution.isPalindrome(input);

		boolean result = output == expected;

		printResult(result, input, output, expected);
	}
	
	public static void romanToInteger(String input, int expected) {
		RomanToInteger solution = new RomanToInteger();
		
		int output = solution.romanToInt(input);
		
		boolean result = output == expected;
		
		printResult(result, input, output, expected);
	}
}
