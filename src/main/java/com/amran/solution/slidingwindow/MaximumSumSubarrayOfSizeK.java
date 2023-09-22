/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

/**
 *
 * @author amranhossain
 * 
 * Given an array of positive integers, and a positive number k, find the maximum sum of any contiguous subarray of size k.

Example 1

Input: [3, 5, 2, 1, 7], k=2 
Output: 8
Explanation: Subarray with maximum sum is [1, 7].
 */
public class MaximumSumSubarrayOfSizeK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {3, 5, 2, 1, 7};
        int k = 2;
        System.out.println(findMaxSumSubarrayOfSizeKBruteForce(arr, k));
    }
    
    public static int findMaxSumSubarrayOfSizeKBruteForce(int[] a, int k) {
        int maxSum = 0, subarraySum;
        for (int i = 0; i <= a.length-k; i++) {
            subarraySum = 0;
            for (int j = i; j < i+k; j++) {
                subarraySum += a[j];
            }
            maxSum = Math.max(maxSum, subarraySum);
        }
        return maxSum;
    }
    
    //Sliding Window Technique
    private static int findSumMaxSubarrayOfSizeK(int[] a, int k) {
        if(k == 0 || a.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            windowSum += a[windowEnd]; // Add the next element to the window
            
            if(windowEnd-windowStart+1 == k) { // When we hit the window size. Update maximum sum, and slide the window
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= a[windowStart]; // Subtract the element going out of the window
                windowStart++; // Slide the window
            }
        }

        return maxSum;
    }
    
}
