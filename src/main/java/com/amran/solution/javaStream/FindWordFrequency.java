/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindWordFrequency {
    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over the lazy dog";

        // Generate a map of each word and its count
        Map<String, Long> wordFrequency = Arrays.stream(sentence.split("\\s+"))
                .map(String::toLowerCase) // Optional: makes the count case-insensitive
                .collect(Collectors.groupingBy(
                        Function.identity(), 
                        Collectors.counting()
                ));

        System.out.println("Word Frequencies: " + wordFrequency);
    }
}
