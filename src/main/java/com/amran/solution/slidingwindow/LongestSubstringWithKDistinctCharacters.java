/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

import java.util.HashMap;

/**
 *
 * @author amranhossain Given a string, find the length of the longest possible
 * substring in it that has exactly K distinct characters. If there is no
 * possible substring then print -1. You can assume that K is less than or equal
 * to the length of the given string.
 *
 * Input: S = "aabacbebebe", K = 3 Output: 7 Explanation: "cbebebe" is the
 * longest substring with 3 distinct characters.
 *
 */
public class LongestSubstringWithKDistinctCharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k = 3;
        String str = "aabacbebebe";
        String str2 = "aaaa";
        System.out.println(LSWKDC(k, str));
    }

    public static int LSWKDC(int k, String str) {
        int len = str.length();
        int windowStart = 0, windowEnd = 0;
        int maxLength = -1;
        HashMap<Character, Integer> windowCharCount = new HashMap<>();
        for (windowEnd = 0; windowEnd < len; windowEnd++) {
            char c = str.charAt(windowEnd);
            windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);
            while (windowCharCount.size() > k) {
                char leftChar = str.charAt(windowStart);

                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (windowCharCount.get(leftChar) == 0) {
                    windowCharCount.remove(leftChar);
                }
                windowStart++;
            }
            if (windowCharCount.size() == k) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }
        }
        return maxLength;
    }

}
