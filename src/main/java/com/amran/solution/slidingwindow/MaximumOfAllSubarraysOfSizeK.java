/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author amranhossain
 * Given an array of integers a, and an integer k, find the maximum for each and every contiguous subarray of size k.

Example

Input: a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3 
Output: 3 3 4 5 5 5 6
Explanation: 
Maximum of subarray {1, 2, 3} is 3
Maximum of subarray {2, 3, 1} is 3
Maximum of subarray {3, 1, 4} is 4
Maximum of subarray {1, 4, 5} is 5
Maximum of subarray {4, 5, 2} is 5
Maximum of subarray {5, 2, 3} is 5
Maximum of subarray {2, 3, 6} is 6
 */
public class MaximumOfAllSubarraysOfSizeK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3;
        int[] result = maxofAllSubarray_BruteForce(a, k);
        System.out.println(Arrays.toString(result));
    }
    
    private static int[] maxofAllSubarray_BruteForce(int[] a, int k) {
        int n = a.length;
        int[] maxOfSubarrays = new int[n - k + 1];
        int idx = 0;

        for(int i = 0; i <= n-k; i++) {
            int maxElement = Integer.MIN_VALUE;
            for(int j = i; j < i+k; j++) {
                if(maxElement < a[j]) {
                    maxElement = a[j];
                }
            }
            maxOfSubarrays[idx++] = maxElement;
        }

        return maxOfSubarrays;
    }
    
    private static int[] maxofAllSubarray(int[] a, int k) {
        int n = a.length;
        int[] maxOfSubarrays = new int[n-k+1];
        int idx = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            q.add(a[windowEnd]);

            if(windowEnd-windowStart+1 == k) { // We've hit the window size. Find the maximum in the current window and Slide the window ahead
                int maxElement = q.peek();
                maxOfSubarrays[idx++] = maxElement;

                if(maxElement == a[windowStart]) { // Discard a[windowStart] since we are sliding the window now. So it is going out of the window.
                    q.remove();
                }

                windowStart++; // Slide the window ahead
            }
        }
        return maxOfSubarrays;
    }
    
}
