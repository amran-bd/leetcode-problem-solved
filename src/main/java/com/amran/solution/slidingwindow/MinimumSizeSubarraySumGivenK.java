/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

/**
 *
 * @author amranhossain
 */
public class MinimumSizeSubarraySumGivenK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 1, 2, 1};
        int k = 9;
        System.out.println(findLengthOfSmallestSubarray(arr, k));
    }
    
    private static int findLengthOfSmallestSubarray_BruteForce(int[] a, int K) {
        int n = a.length;
        int lengthOfSmallestSubarray = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int currentSubarraySum = 0;
            for(int j = i; j < n; j++) {
                currentSubarraySum += a[j];

                if(currentSubarraySum >= K) {
                    lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, j-i+1);
                    break;
                }
            }
        }

        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }
    
    //Sliding Window O(n), SP O(1)
    private static int findLengthOfSmallestSubarray(int[] a, int K) {
        int n = a.length;

        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += a[windowEnd]; // Add the next element to the window

            while(windowSum >= K) { // Shrink the window as small as possible until the 'windowSum' is smaller than 'K'
                lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, windowEnd-windowStart+1);
                windowSum -= a[windowStart]; // Discard the element at 'windowStart' since it is going out of the window
                windowStart++; // Shrink the window
            }
        }

        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }
    
}
