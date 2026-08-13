package com.amran.solution.arrays_dsa;

/**
 * @author Md Amran Hossain on 13/8/2026 AD
 * @Project leetcode-problem-solved
 */
public class FindArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(" 153 is Armstrong Number ?  = " + isArmstrongNumber(153));
        System.out.println(" 123 is Armstrong Number ?  = " + isArmstrongNumber(123));
    }

    public static boolean isArmstrongNumber(int num) {
        int length = String.valueOf(num).length();
        int tmp = num;
        int sum = 0;
        if (num == 0) return false;
        while (tmp != 0) {
            int singleDigit = tmp % 10;
            sum += (int) Math.pow(singleDigit, length);
            tmp /= 10;
        }
        return sum == num;
    }
}

// Complexity BigO(1)
/*
Why this works:For 153, totalDigits is 3.The loop extracts 3, 5, and 1 from tmp.Math.pow(singleDigit, totalDigits)
correctly calculates 3³ + 5³ + 1³ = 27 + 125 + 1 = 153.sum == num evaluating 153 == 153 returns true.

The time complexity is \(O(\log_{10} N)\) and
the space complexity is \(O(\log_{10} N)\)
(or \(O(1)\) if you do not count the temporary string creation).
 */