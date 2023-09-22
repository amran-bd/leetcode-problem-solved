/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author amranhossain
 * Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
 * Examples 1

Input: text = forxxorfxdofr, word = for
Output : 3
Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
 */
public class CountOccurrencesOfAnagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";
        int count = countOccurrenceOfAnagram(text, word);
        System.out.println(count);
    }
    
    private static int countOccurrenceOfAnagram(String text, String word) {
        int n = text.length();
        int k = word.length();
        int count = 0;

        // Calculate the count of each character for the given word
        Map<Character, Integer> wordCharCount = new HashMap<>();
        for(int i = 0; i < k; i++) {
            char c = word.charAt(i);
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0)+1);
        }

        // Stores the characrer count for the current substring (current window)
        Map<Character, Integer> substrCharCount = new HashMap<>();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            char c = text.charAt(windowEnd);
            substrCharCount.put(c, substrCharCount.getOrDefault(c, 0) + 1); // Include the next char in the window

            if(windowEnd-windowStart+1 == k) { // We've hit the window size. Calculate result and Slide the window
                if(isAnagram(wordCharCount, substrCharCount)) {
                    count++;
                }

                // Reduce count for the char at windowStart since we are sliding the window now
                substrCharCount.put(text.charAt(windowStart), substrCharCount.get(text.charAt(windowStart)) - 1);
                windowStart++; // Slide the window ahead
            }
        }
        return count;
    }
    
    // Two words are anagrams of each other if the count of every character in both the words are same.
    private static boolean isAnagram(Map<Character, Integer> word1CharCount, Map<Character, Integer> word2CharCount) {
        for(char c : word1CharCount.keySet()) {
            if(!Objects.equals(word1CharCount.get(c), word2CharCount.get(c))) {
                return false;
            }
        }
        return true;
    }
    
}
