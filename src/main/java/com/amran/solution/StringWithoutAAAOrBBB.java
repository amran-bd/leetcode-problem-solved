/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class StringWithoutAAAOrBBB {

    public static void main(String[] args) {
        System.out.println("");
    }

    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            String s = sb.toString();
            // if we have aa as the last 2 characters, then the next one is b
            if (s.endsWith("aa")) {
                sb.append("b");
                b--;
            } // if we have bb as the last 2 characters, then the next one is a
            else if (s.endsWith("bb")) {
                sb.append("a");
                a--;
            } // if a > b, append a
            else if (a > b) {
                sb.append("a");
                a--;
            } // if b >= a, append b
            else {
                sb.append("b");
                b--;
            }
        }
        return sb.toString();
    }
    
    // Time complexity O(a+b), Space complexity O(a+b)
}
