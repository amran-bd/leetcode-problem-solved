/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

import java.util.Arrays;

/**
 *
 * @author amranhossain
 * Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class MaximumSubarraySumGivenIntegerSizeOfK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 9, 5, 1, 2};
        int k = 3; // size of sub arry
        System.out.println(findMaximumSubarraySum(k, arr));
        System.err.println(findMaxSubarraySumSlideWindow(k, arr));

    }

    //Brute Force Apply where complexity O(n2)
    public static int findMaximumSubarraySum(int k, int[] arr) {
        int maxSum = 0, windowSubArraySum;

        for (int i = 0; i <= arr.length - k; i++) {
            windowSubArraySum = 0;
            for (int j = i; j < k + i; j++) {
                windowSubArraySum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSubArraySum);
        }
        return maxSum;
    }

    //Optimized Solution where complexity is O(n) and space time O(1)
    public static int findMaxSubarraySumSlideWindow(int k, int[] arr) {
        
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add the next element to the window
            
            if(windowEnd-windowStart+1 == k) { // When we hit the window size. Update maximum sum, and slide the window
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // Subtract the element going out of the window
                windowStart++; // Slide the window
            }
        }
        return maxSum;
    }
}
