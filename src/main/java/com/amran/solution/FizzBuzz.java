/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Amran Hossain
 */
public class FizzBuzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestCase.assertEquals("[1, 2, Fizz]",fizzBuzz(3));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        int fizz = 0, buzz = 0;
        for (int i = 1; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                fizz = 0;
                buzz = 0;
                output.add("FizzBuzz");
            } else if (fizz == 3) {
                fizz = 0;
                output.add("Fizz");
            } else if (buzz == 5) {
                buzz = 0;
                output.add("Buzz");
            } else {
                output.add(Integer.toString(i));
            }
        }
        return output;
    }

    public static List<String> fizzBuzzMode(int n) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                output.add("FizzBuzz");
            } else if (i % 3 == 0) {
                output.add("Fizz");
            } else if (i % 5 == 05) {
                output.add("Buzz");
            } else {
                output.add(Integer.toString(i));
            }
        }
        return output;
    }

}
