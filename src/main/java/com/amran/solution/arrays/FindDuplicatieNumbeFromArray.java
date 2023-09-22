/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class FindDuplicatieNumbeFromArray {

    /**
     * @param args the command line arguments
     *
     * Declare and initialize an array. Duplicate elements can be found using
     * two loops. The outer loop will iterate through the array from 0 to length
     * of the array. The outer loop will select an element. The inner loop will
     * be used to compare the selected element with the rest of the elements of
     * the array. If a match is found which means the duplicate element is found
     * then, display the element.
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 2, 7, 8, 8, 3};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[j]);
                }
            }
        }

//        Solution 2
        Set testSet = new HashSet();
        for (int value : arr) {
            if (testSet.add(value) == false) {
                System.out.println("Duplicate Entry: " + value);
            }
        }
    }

}

//Solution 2 :
//Second solution is even simpler than this. All you need to know is that 
//        Set doesn't allow duplicates in Java. Which means if you have added an element into Set and trying to insert duplicate element again, 
//it will not be allowed. In Java, you can use HashSet class to solve this problem. 
//        Just loop over array elements, insert them into HashSet using add() method and check return value. 
//        If add() returns false it means that element is not allowed in the Set and that is your duplicate. Here is the code sample to do this :
//
//Complexity of this solution is O(n) because you are only going through array one time, 
//        but it also has space complexity of O(n) because of HashSet data structure, 
//        which contains your unique elements. So if an array contains 1 million elements, 
//        in worst case you would need an HashSet to store those 1 million elements.
//
//Read more: https://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html#ixzz65oqxLCD7
