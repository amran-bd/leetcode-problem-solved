/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.Arrays;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class FindSecondLargestFormArray {

    /**
     * @param args the command line arguments Array Must be sorted
     */
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 8, 2, 5, 10,9};
        //If array list is not sorted
        Arrays.sort(array);
        int index = array.length - 1;
        while (array[index] == array[array.length - 1]) {
            index--;
        }
        System.out.println("Second largest value: " + array[index]);
    }
}
