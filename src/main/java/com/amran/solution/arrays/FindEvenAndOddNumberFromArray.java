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
public class FindEvenAndOddNumberFromArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array_nums = {5, 7, 2, 4, 9};
        System.out.println("Original Array: " + Arrays.toString(array_nums));
        int ctr = 0;
        for (int i = 0; i < array_nums.length; i++) {
            if (array_nums[i] % 2 == 0) {
                ctr++;
            }
        }
        System.out.println("Number of even numbers : " + ctr);
        System.out.println("Number of odd numbers  : " + (array_nums.length - ctr));
    }

}
