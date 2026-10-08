/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindNonRepeatedCharacter {
    
    public static void main(String[] args) {
        String input = "swiss";

        // Find the first non-repeated character
        Character firstNonRepeated = input.chars()           // IntStream of characters
                .mapToObj(c -> (char) c)                     // Convert to Stream<Character>
                .collect(Collectors.groupingBy(
                        Function.identity(), 
                        LinkedHashMap::new,                  // Keeps the insertion order intact
                        Collectors.counting()                // Counts occurrences
                ))
                .entrySet().stream()                         // Stream the map entries
                .filter(entry -> entry.getValue() == 1)      // Keep only non-repeated elements
                .map(Map.Entry::getKey)                      // Get the character key
                .findFirst()                                 // Grab the very first one
                .orElse(null);                               // Return null if all characters repeat

        System.out.println("First non-repeated character: " + firstNonRepeated);
    }
}
