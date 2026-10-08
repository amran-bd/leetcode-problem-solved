/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class RemoveDuplicatesFromList {
    
    public static void main(String[] args) {
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3, 6);

        // Remove duplicate elements
        List<Integer> uniqueNumbers = numbersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique Elements: " + uniqueNumbers);
    }
}
