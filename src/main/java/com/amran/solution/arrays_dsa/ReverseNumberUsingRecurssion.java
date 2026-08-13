package com.amran.solution.arrays_dsa;

/**
 * @author Md Amran Hossain on 13/8/2026 AD
 * @Project leetcode-problem-solved
 */
public class ReverseNumberUsingRecurssion {

    public static void main(String[] args) {
        System.out.println("Enter the number to be reversed : "+ reverse(123));
        System.out.println("Enter the number to be reversed : "+ reverse(1000));
        System.out.println("Enter the number to be reversed : "+ reverse(-67));
    }

    static int reverseHelper(int number, int result) {
        if (number == 0) return result;
        return reverseHelper(number/10, result * 10 + number % 10);
    }

    public static int reverse(int number) {
        // Handle negative numbers by converting to positive, then flipping back
        if (number < 0) {
            return -reverseHelper(-number, 0);
        }
        return reverseHelper(number, 0);
    }
}

//The time complexity is \(O(\log_{10} N)\)
// and the space complexity is \(O(\log_{10} N)\), where \(N\) is the input number.
