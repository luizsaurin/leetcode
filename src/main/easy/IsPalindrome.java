package main.easy;

import test.TestRunner;

/**
 * @see https://leetcode.com/problems/palindrome-number/
 */
public class IsPalindrome {
	public boolean isPalindrome(int x) {

		if (x < 0 || (x % 10 == 0 && x != 0)) return false;

		int original = x;
		int reversed = 0;

		while (original > reversed) {
			reversed = (reversed * 10) + (original % 10);
			original /= 10;
		}

		return original == reversed || original == reversed / 10;
	}

	public static void main() {
		TestRunner.isPalindrome(121, true);
		TestRunner.isPalindrome(-121, false);
		TestRunner.isPalindrome(10, false);
		TestRunner.isPalindrome(1221, true);
	}
}
