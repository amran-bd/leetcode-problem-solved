/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author amranhossain Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "aababcbb" Output: 3 Explanation: The longest substring without
 * repeating characters is "abc". Example 2:
 *
 * Input: s = "cccc" Output: 1 Explanation: The longest substring without
 * repeating characters is "c". Example 3:
 *
 * Input: s = "" Output: 0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "aababcbb";
        System.out.println(findLongestSubStrWRCLengthSlidingWindow(str));
    }

    //OutOfBox Solution
    public static int findLongestSubStrWRCLength(String str) {
        if (str.length() == 0 || str.isEmpty()) {
            return 0;
        }
        char[] arr = str.toCharArray();
        TreeSet<Character> list = new TreeSet<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
        return list.size();
    }

    //Sliding Window technique
    public static int findLongestSubStrWRCLengthSlidingWindow(String str) {
        int len = str.length();
        int windowStart = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> windowCharCount = new HashMap<>(); // Stores the character count for each character in the current window
        for (int windowEnd = 0; windowEnd < len; windowEnd++) {
            char c = str.charAt(windowEnd);
            windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);
            // Shrink the window until all the characters in the window are unique
            while (windowCharCount.size() < windowEnd - windowStart + 1) {
                char leftChar = str.charAt(windowStart);

                // Discard the character at windowStart since we're gonna move it out of the window now.
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (windowCharCount.get(leftChar) == 0) {
                    windowCharCount.remove(leftChar);
                }

                windowStart++; // Shrink the window  
            }
            // We have a window where all the characters are unique. Update the max length
            if(windowCharCount.size() == windowEnd-windowStart+1) {
                maxLen =Math.max(maxLen, windowEnd-windowStart+1);
            }
        }
        return maxLen;
    }
}
