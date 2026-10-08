/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author amranhossain
 */
public class FindFirstRepeatedCharacter {
    
    public static void main(String[] args) {
        String input = "swiss";

        Set<Character> seen = new HashSet<>();

        // Find the first repeated character
        Character firstRepeated = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c)) // If add returns false, it's a duplicate
                .findFirst()               // Stop processing and grab the very first one
                .orElse(null);             // Return null if no characters repeat

        System.out.println("First repeated character: " + firstRepeated);
    }
}
