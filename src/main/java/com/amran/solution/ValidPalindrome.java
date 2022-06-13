/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class ValidPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(""+isPalindrome(s));
    }
    
    public static boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        //Remove non-alpha numeric
        String removeNonAlphaNum = lowerCase.replaceAll("[^A-Za-z0-9]", "");
        String backWard = "";
        for(int i =removeNonAlphaNum.length()-1; i>=0; i--){
            backWard +=removeNonAlphaNum.charAt(i);
        }
        System.out.println(removeNonAlphaNum);
        System.out.println(backWard);
        if(removeNonAlphaNum.equals(backWard)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
}
