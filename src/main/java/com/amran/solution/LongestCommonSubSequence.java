/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class LongestCommonSubSequence {

    /*
    Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "bcd";
        System.out.println(lengthLCS(text1, text2));
    }

    //Dynamic Programming solution (Bootom to up solution)
    public static int lengthLCS(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] LCS = new int[l1 + 1][l2 + 1];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (text1.charAt(i) == (text2.charAt(j))) {
                    LCS[i][j] = LCS[i + 1][j + 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i + 1][j], LCS[i][j + 1]);
                }
            }
        }
        System.out.println(LCS[0][0]);
        return LCS[0][0];
    }

}
