/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.bfs;

import java.util.Arrays;

/**
 *
 * @author amranhossain
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {3,6,8,9,44,76,89};
        int target = 44;
        System.out.println(binarySearch(arr, target));
        System.out.println(Arrays.binarySearch(arr, target));
    }
    
    private static int binarySearch(int[] a, int target) {
        int start = 0;
        int end = a.length-1;

        while(start <= end) {
            int mid = (start + end)/2;

            if(target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return -1;
    }
    
}
