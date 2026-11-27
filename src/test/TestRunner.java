package test;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Lightweight, dependency-free testing utility for LeetCode solutions. Test
 * results, formats inputs and outputs, and prints a color-coded result and
 * summary to the console.
 * 
 * For now, it supports simple structures such as:
 * int, Integer, boolean, Boolean, String, int[], boolean[], String[], int[][],
 * Object[]
 * 
 * More complex structures such as Linked Lists and Binary Trees may need custom
 * comparison methods
 * 
 * @version 2.0
 */
@SuppressWarnings({ "java:S1118", "java:S106" })
public class TestRunner {

	private static final String BLUE = "\u001B[34m";
	private static final String GREEN = "\u001B[32m";
	private static final String RED = "\u001B[31m";
	private static final String RESET = "\u001B[0m";
	private static int totalTests = 0;
	private static int passedTests = 0;
	private static int failedTests = 0;

	public static void run(String name, Object input, Object expected, Supplier<?> execution) {

		long start = System.nanoTime();

		Object output = execution.get();

		long elapsed = System.nanoTime() - start;

		boolean passed = Objects.deepEquals(output, expected);

		totalTests++;

		if (passed) {
			passedTests++;
		} else {
			failedTests++;
		}

		String status = passed
				? GREEN + "PASSED" + RESET
				: RED + "FAILED" + RESET;

		System.out.printf(
				"[%s] %s | Input: %s | Output: %s | Expected: %s | Time: %.3f ms%n",
				status,
				name,
				format(input),
				format(output),
				format(expected),
				elapsed / 1_000_000.0);

	}

	public static void printSummary() {

		String summary = String.format("%s%s%s", BLUE, "SUMMARY", RESET);
		String total = String.format("Total: %d", totalTests);
		String passed = String.format("%sPassed: %d%s", GREEN, passedTests, RESET);
		String failed = String.format("%sFailed: %d%s", RED, failedTests, RESET);

		System.out.printf("[%s] %s | %s | %s", summary, total, passed, failed);

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