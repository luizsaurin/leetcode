package main.easy;

import test.TestRunner;

/**
 * @see https://leetcode.com/problems/palindrome-number/
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int original = x;
        int reversed = 0;

        while (original > reversed) {
            reversed = (reversed * 10) + (original % 10);
            original /= 10;
        }

        return original == reversed || original == reversed / 10;
    }

    @SuppressWarnings("java:S1172")
    public static void main(String[] args) {

        IsPalindrome solution = new IsPalindrome();

        String name = IsPalindrome.class.getSimpleName();

        TestRunner.run(name, 121, true, () -> solution.isPalindrome(121));
        TestRunner.run(name, -121, false, () -> solution.isPalindrome(-121));
        TestRunner.run(name, 10, false, () -> solution.isPalindrome(10));
        TestRunner.run(name, 1221, true, () -> solution.isPalindrome(1221));

        TestRunner.printSummary();
    }
}