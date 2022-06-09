/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amran Hossain
 */
public class DecodeWays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        List<String> output = new LinkedList<>();
        int ways[] = new int[len + 1];
        ways[0] = 1;
        ways[1] = s.charAt(0) != '0' ? 1 : 0;

        char[] cArry = s.toCharArray();

        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                ways[i] = ways[i - 1];
            }
            int a = (s.charAt(i - 2) - '0');
            int val = a * 10 + (s.charAt(i - 1) - '0');
            if (val <= 26 && val >= 10) {
                ways[i] += ways[i - 2];
            }
        }
        return ways[len];
    }

    private String getAlphabet(String key) {
        Map<String, String> map = new HashMap();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
        map.put("13", "M");
        map.put("14", "N");
        map.put("15", "O");
        map.put("16", "P");
        map.put("17", "Q");
        map.put("18", "R");
        map.put("19", "S");
        map.put("20", "T");
        map.put("21", "U");
        map.put("22", "V");
        map.put("23", "W");
        map.put("24", "X");
        map.put("25", "Y");
        map.put("26", "Z");
        return map.get(key);
    }

}
