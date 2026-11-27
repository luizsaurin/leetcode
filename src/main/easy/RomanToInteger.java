package main.easy;

import test.TestRunner;

/**
 * @see https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

	public int romanToInt(String s) {
		int total = 0;

		for (int i = 0; i < s.length(); i++) {
			int current = VALUES[s.charAt(i)];

			if (i + 1 < s.length() &&
					current < VALUES[s.charAt(i + 1)]) {
				total -= current;
			} else {
				total += current;
			}
		}

		return total;
	}

	private static final int[] VALUES = new int[128];

	static {
		VALUES['I'] = 1;
		VALUES['V'] = 5;
		VALUES['X'] = 10;
		VALUES['L'] = 50;
		VALUES['C'] = 100;
		VALUES['D'] = 500;
		VALUES['M'] = 1000;
	}

	@SuppressWarnings("java:S1172")
	public static void main(String[] args) {

		RomanToInteger solution = new RomanToInteger();

		String name = RomanToInteger.class.getSimpleName();

		TestRunner.run(name, "III", 3, () -> solution.romanToInt("III"));
		TestRunner.run(name, "LVIII", 58, () -> solution.romanToInt("LVIII"));
		TestRunner.run(name, "MCMXCIV", 1994, () -> solution.romanToInt("MCMXCIV"));

		TestRunner.printSummary();
	}
}