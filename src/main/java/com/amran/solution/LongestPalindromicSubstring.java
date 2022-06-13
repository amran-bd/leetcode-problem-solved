/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class LongestPalindromicSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println("" + longestPalindrome(s));
        System.out.println("" + longestPalindrome2(s));
    }

    //Broute Froce 
    public static int longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 1, start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        flag = 0;
                    }
                }

                // Palindrome
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return maxLength;
    }

    // Dynamic Programming
    public static String longestPalindrome2(String s) {
        int n = s.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            palindrom[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || palindrom[i + 1][j - 1])) {
                    palindrom[i][j] = true;
                    if (j - i + 1 > longestSoFar) {
                        longestSoFar = j - i + 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

}
