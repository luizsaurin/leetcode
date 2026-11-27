package main.easy;

import java.util.HashMap;
import java.util.Map;

import test.TestRunner;

/**
 * @see https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

	public int romanToInt(String s) {

		Map<Character, Integer> numbers = new HashMap<>();
		numbers.put('I', 1);
		numbers.put('V', 5);
		numbers.put('X', 10);
		numbers.put('L', 50);
		numbers.put('C', 100);
		numbers.put('D', 500);
		numbers.put('M', 1000);

		int total = 0;
		int i = 0;

		while (i < s.length()) {
			Integer current = numbers.get(s.charAt(i));

			if (i + 1 < s.length()) {
				Integer next = numbers.get(s.charAt(i + 1));

				if (current < next) {
					total += next - current;
					i += 2;
					continue;
				}
			}

			total += current;
			i++;
		}

		return total;
	}

	@SuppressWarnings("java:S1172")
	public static void main(String[] args) {

		RomanToInteger solution = new RomanToInteger();

		String name = RomanToInteger.class.getSimpleName();

		TestRunner.run(name, "III", 3, solution.romanToInt("III"));
		TestRunner.run(name, "LVIII", 58, solution.romanToInt("LVIII"));
		TestRunner.run(name, "MCMXCIV", 1994, solution.romanToInt("MCMXCIV"));
	}
}