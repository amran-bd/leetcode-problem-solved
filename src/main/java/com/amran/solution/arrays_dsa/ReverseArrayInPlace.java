/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.arrays_dsa;

import java.util.Arrays;

/**
 *
 * @author amranhossain
 */
public class ReverseArrayInPlace {
    
    public static void main(String[] args) {
        String arr[] = {"h","e","l","l","o"};
        System.out.println("Reverse In Place: "+Arrays.toString(reverse(arr)));
    }
    
    //Solution 2Pointer Approch - Time O(n), Space O(1)
    public static String[] reverse (String arr[]){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}
