/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author amranhossain
 */
public class FindLongestString {
    
    public static void main(String[] args) {
        List<String> programmingLanguages = Arrays.asList(
            "Java", "Python", "JavaScript", "C++", "Go", "Kotlin"
        );

        // Find the longest string using max and comparing length
        String longest = programmingLanguages.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(""); // Default fallback if the list is empty

        System.out.println("Longest String: " + longest);
    }
}
