/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindDuplicateElementInList {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7,8,9,2,3,4,5,7,6,9);
        
        // Find duplicates by checking their frequency in the original list
        List<Integer> duplicates = numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) > 1)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Duplicate Elements: " + duplicates);
    }
    
    /*
    Set<Integer> seen = new HashSet<>();

        // Find all duplicate elements
        List<Integer> duplicates = numbers.stream()
                .filter(num -> !seen.add(num)) // If add returns false, it's a duplicate
                .distinct()                    // Ensure the output list only lists each duplicate once
                .collect(Collectors.toList());
    */
    
}
