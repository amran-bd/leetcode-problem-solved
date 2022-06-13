/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class PalindromeNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int input = 121;
        System.out.println(isPalindrome(input));
        System.out.println(isPalindrome2(input));
    }

    public static boolean isPalindrome(int x) {
        int reversed_number = 0;
        int tmp = x;
        while (tmp > 0) {
            int last_digit = tmp % 10; // the reminder after dividing by 10
            tmp = tmp / 10; //since we already have the last digit, remove the last digit from the original_number
            reversed_number = reversed_number * 10 + last_digit;//multiply the reversed_number with 10, so as to add the last_digit to it
        }
        return x == reversed_number;
    }
    
    public static boolean isPalindrome2(int x) {
        String s = Integer.toString(x);
        String backWard = "";
        for(int i = s.length()-1; i>=0; i--){
            backWard +=s.charAt(i);
        }
        if(s.equals(backWard)){
            return true;
        }
        return false;
    }
}
