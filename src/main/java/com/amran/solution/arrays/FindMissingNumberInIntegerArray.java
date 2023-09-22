/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.Scanner;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class FindMissingNumberInIntegerArray {
    

    /**
     * @param args the command line arguments
     * 
    1.Find the sum of n number using formula n=n*(n+1)/2
    2.Find the sum of elements present in given array.
    3.Substract (sum of n numbers – sum of elements present in the array).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int[] array = {5,4,1,2};
        int n = array.length + 1;
        int sum = n*(n+1)/2;
	int restSum = 0;
	for (int i = 0; i < array.length; i++) {
            restSum += array[i];
	}
	int missingNumber = sum - restSum;
	System.out.println("Missing Number Is: "+missingNumber);
    }
    
}
