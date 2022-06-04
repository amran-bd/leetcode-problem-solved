/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Amran Hossain
 */
public class WordBreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("neet");
        dict.add("leet");
        dict.add("code");
        String input = "leetcode";
        System.out.println(wordBreak1(input, dict));
    }

    //Dynamic Programming Solution. (Bootom Up solution)
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set< String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[s.length()];
    }

    //Alternate solution but not execute all test case
    public static boolean wordBreak1(String s, List<String> wordDict) {
        int defaultLen = 0;
        String output = "";
        for (String str : wordDict) {
            String fromInput = s.substring(defaultLen, str.length() + defaultLen);
            if (fromInput.equals(str)) {
                defaultLen = str.length();
                output += str;
            }
        }
        return s.endsWith(output);
    }

    @Test
    public void test() {
        List<String> dict = new ArrayList<>();
        dict.add("neet");
        dict.add("leet");
        dict.add("code");
        String input = "leetcode";
        Assert.assertEquals(true, wordBreak(input, dict));
    }
}
