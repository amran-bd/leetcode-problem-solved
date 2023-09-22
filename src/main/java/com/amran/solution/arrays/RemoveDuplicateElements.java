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
public class RemoveDuplicateElements {

    static void unique_array(int[] my_array) {
//        //Assuming all elements in input array are unique
        int no_unique_elements = my_array.length;
        //Comparing each element with all other elements
        for (int i = 0; i < no_unique_elements; i++) {
            for (int j = i + 1; j < no_unique_elements; j++) {
                //If any two elements are found equal
                if (my_array[i] == my_array[j]) {
                    //Replace duplicate element with last unique element
                    my_array[j] = my_array[no_unique_elements - 1];
                    no_unique_elements--;
                    j--;
                }
            }
        }
        //Copying only unique elements of my_array into array1
        int[] array1 = Arrays.copyOf(my_array, no_unique_elements);
        //Printing arrayWithoutDuplicates
        System.out.println("Array with unique values : "+Arrays.toString(array1));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        unique_array(new int[]{0, 3, -2, 4, 3, 2});
        unique_array(new int[]{10, 22, 10, 20, 11, 22});
    }

}
