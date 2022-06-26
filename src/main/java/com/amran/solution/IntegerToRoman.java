/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class IntegerToRoman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 58;
        System.out.println("" + intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] v = {1000, 500, 100, 50, 10, 5, 1};
        String[] s = {"M", "D", "C", "L", "X", "V", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            while (num >= v[i]) {
                num -= v[i];
                sb.append(s[i]);
            }
        }
        return sb.toString();
    }

}
