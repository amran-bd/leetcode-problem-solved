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
public class FindSecondSmallestFormArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] my_array = {-1, 4, 0, 2, 7, -3};
        System.out.println("Original numeric array : " + Arrays.toString(my_array));
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        for (int i = 0; i < my_array.length; i++) {
            if (my_array[i] == min) {
                second_min = min;
            } else if (my_array[i] < min) {
                second_min = min;
                min = my_array[i];
            } else if (my_array[i] < second_min) {
                second_min = my_array[i];
            }
        }
        System.out.println("Second lowest number is : " + second_min);
    }

}
