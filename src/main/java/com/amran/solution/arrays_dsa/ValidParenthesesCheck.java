package com.amran.solution.arrays_dsa;

import java.util.Stack;

/**
 * @author Md Amran Hossain on 13/8/2026 AD
 * @Project leetcode-problem-solved
 */
public class ValidParenthesesCheck {

    public static void main(String[] args) {
        System.out.println("({[]}) -> result: " + checkValidParentheses("({[]})"));
        System.out.println("({[}]) -> result: " + checkValidParentheses("({[}])"));
    }

    static boolean checkValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

//Complexity BigO(n)
