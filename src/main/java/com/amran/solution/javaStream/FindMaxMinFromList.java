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
public class FindMaxMinFromList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 42, 3, 89, 7, 66, 23);

        // Find the maximum value
        int max = numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0); // Default if list is empty

        // Find the minimum value
        int min = numbers.stream()
                .min(Comparator.naturalOrder())
                .orElse(0); // Default if list is empty

        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }
}
