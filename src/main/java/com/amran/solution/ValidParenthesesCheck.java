/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amran Hossain
 */
public class ValidParenthesesCheck {
/**
     * Given a string s containing just the characters '(', ')', '{', '}', '['
     * and ']', determine if the input string is valid.An input string is valid
     * if:
     *
     * Open brackets must be closed by the same type of brackets. Open brackets
     * must be closed in the correct order.
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "()[}";
        System.out.println("Is Valid : " + isValid(s));
    }
    
    //It's for single
//    static boolean isValid(String s) {
//        int opened = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                opened++;
//            } else if (s.charAt(i) == ')') {
//                if (opened == 0) {
//                    return false;
//                }
//                opened--;
//            } 
//                
//            
//        }
//        return opened == 0;
//    }
    
    static boolean checkParentheses(String s) {
        // capture a text starting with one opening parenthesis, 
        // ending with one closing and having no parentheses inside
        Pattern p = Pattern.compile("\\([^()]*\\)");        
        Matcher m;
        while ((m = p.matcher(s)).find()) {
            s = m.replaceAll("");
        }
        return !(s.contains("(") || s.contains(")"));
    }
    
    public static boolean isValid(String expression) {
        if ((expression.length() % 2) == 1) return false;
        else {
            Stack<Character> s = new Stack<>();
            for (char bracket : expression.toCharArray())
                switch (bracket) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.isEmpty() || bracket != s.peek()) { return false;}
                        s.pop();
                }
            return s.isEmpty();
        }
    }
}
