/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Amran Hossain
 */
public class FindCommonCharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        System.out.println("" + commonChars(words));

        String[] words2 = {"cool", "lock", "cook"};
        System.out.println("" + commonChars(words2));
        
        System.out.println("" + commonChars2(words));
        System.out.println("" + commonChars2(words2));
    }

    public static List<String> commonChars(String[] words) {
        List<String> output = new ArrayList<>();
        if (words.length == 0) {
            return output;
        }
        int len = words.length;
        int count = 1;
        char[] firstWordArry = words[0].toCharArray();
        for (int i = 0; i < firstWordArry.length; i++) {
            String outputStr = String.valueOf(firstWordArry[i]);
            for (int j = 1; j < len; j++) {
                String word = words[j];
                if (word.contains(outputStr)) {
                    count++;
                }
                if (count == len) {
                    output.add(outputStr);
                }
            }
            count = 1;
        }
        return output;
    }

    //Dynamic Programing O(n2)
    public static List<String> commonChars2(String[] words) {
        List<String> res = new LinkedList<>();
        int[] min = new int[26];
        Arrays.fill(min,100);
        for (String s : words) {
            int[] cur = new int[26];
            char[] ca = s.toCharArray();
            for (char c : ca) {
                cur[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                min[i] = Math.min(min[i], cur[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < min[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
