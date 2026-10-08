/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindCommonElementsFrom2List {
    
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        // Convert the second list to a Set for O(1) fast lookups
        Set<Integer> set2 = list2.stream().collect(Collectors.toSet());

        // Filter elements from list1 that exist in list2
        List<Integer> commonElements = list1.stream()
                .filter(set2::contains)
                .distinct() // Prevents duplicate matches if list1 has duplicates
                .collect(Collectors.toList());

        System.out.println("Common Elements: " + commonElements);
    }
}
