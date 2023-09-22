/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.sorting;

import java.util.Arrays;

/**
 *
 * @author Amran
 */
public class ArraySort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = {1, 2, 5, 9, 3};
        int temp = 0;
        //built in API
        //Arrays.sort(arr);
        // Sorts IntArray in descending order 
        //Arrays.sort(arr, Collections.reverseOrder()); 
        //System.out.printf("Modified arr[] : %s",Arrays.toString(arr));
        //Sort the array in ascending order using two for loops    
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {      //swap elements if not in order
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //print sorted array    
        System.out.println("\nArray sorted in ascending order: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}


//Alpha numeric sort
//String str_Array[] = {"Java", "Python", "Perl", "C++", "C#", "AS400"}; 
// 
//        System.out.printf("Original Array: \n%s\n\n", Arrays.toString(str_Array));
// 
//        // Sorts str_Array in ascending order 
//        Arrays.sort(str_Array); 
//        System.out.printf("Array sorted in ascending order: \n%s\n\n",                        
//               Arrays.toString(str_Array)); 
// 
//        // Sorts str_Array in descending order 
//        Arrays.sort(str_Array, Collections.reverseOrder()); 
// 
//        System.out.printf("Array sorted in descending order : \n%s\n\n", 
//              Arrays.toString(str_Array));


//Using Java -8
//int[] arr2 = new int[]{54, 432, 53, 21, 43};
//int[] sortedArray = Arrays.stream(arr2)
//        .boxed()
//        .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
//        .mapToInt(Integer::intValue)
//        .toArray();