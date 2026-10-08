/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class PartitionEvenOdd {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 5, 8, 23, 44, 91, 14, 7);

        // Partition numbers into even (true) and odd (false)
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        // Extract lists from the map
        List<Integer> evenNumbers = partitionedNumbers.get(true);
        List<Integer> oddNumbers = partitionedNumbers.get(false);

        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
