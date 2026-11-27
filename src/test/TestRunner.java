package test;

import java.util.Arrays;
import java.util.Objects;

/**
 * Lightweight, dependency-free testing utility for LeetCode solutions. Test results, formats inputs and outputs, 
 * and prints a color-coded result to the console.
 * 
 * For now, it supports simple structures such as:
 * int, Integer, boolean, Boolean, String, int[], boolean[], String[], int[][], Object[]
 * 
 * More complex structures such as Linked Lists and Binary Trees may need custom comparison methods
 * 
 * @version 1.0
 */
@SuppressWarnings({ "java:S1118", "java:S106" })
public class TestRunner {

	private static final String GREEN = "\u001B[32m";
	private static final String RED = "\u001B[31m";
	private static final String RESET = "\u001B[0m";

	public static void run(String name, Object input, Object expected, Object output) {

		boolean passed = Objects.deepEquals(output, expected);

		String status = passed
				? GREEN + "PASSED" + RESET
				: RED + "FAILED" + RESET;

		System.out.printf(
				"[%s] %s | Input: %s | Output: %s | Expected: %s%n",
				status,
				name,
				format(input),
				format(output),
				format(expected));
	}

	private static String format(Object value) {

		if (value == null) {
			return "null";
		}

		if (value.getClass().isArray()) {
			return Arrays.deepToString(new Object[] { value })
					.replaceFirst("^\\[", "")
					.replaceFirst("\\]$", "");
		}

		return value.toString();
	}
}