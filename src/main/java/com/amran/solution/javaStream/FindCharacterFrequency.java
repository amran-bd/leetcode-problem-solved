/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindCharacterFrequency {
    
    public static void main(String[] args) {
        String input = "hello world";

        // Generate a map of each character and its count
        Map<Character, Long> charFrequency = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), 
                        Collectors.counting()
                ));

        System.out.println("Character Frequencies: " + charFrequency);
    }
}
