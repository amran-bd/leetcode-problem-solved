/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author amranhossain
 * Given an array of integers a, and a positive integer k, find the first negative integer for each and every window (contiguous subarray) of size k.
 * If a window does not contain a negative integer, then print 0 for that window.
 * Example 1

Input: a[] = {-5, 1, 2, -6, 9}, k = 2
Output : -5 0 -6 -6

Explanation: First negative integer in every window of size 2
{-5, 1} = -5
{1, 2} = 0 (does not contain a negative integer)
{2, -6} = -6
{-6, 9} = -6
 */
public class FirstNegativeNumberInEveryWindowOfSizek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {-5, 1, 2, -6, 9};
        int k = 2;
        System.out.println(Arrays.toString(findFirstNegativeNumberInSubarrayOfSizeK_BruteForce(arr, k)));
        System.out.println(Arrays.toString(findFirstNegativeNumberInSubarrayOfSizeK(arr, k)));
    }
    
    private static int[] findFirstNegativeNumberInSubarrayOfSizeK_BruteForce(int[] a, int k) {
        int n = a.length;
        int[] firstNegativeNumbers = new int[n - k + 1];
        int idx = 0;

        for(int i = 0; i <= n-k; i++) {
            int firstNegativeNum = 0;
            for(int j = i; j < i+k; j++) {
                if(a[j] < 0) {
                    firstNegativeNum = a[j];
                    break;
                }
            }
            firstNegativeNumbers[idx++] = firstNegativeNum;
        }

        return firstNegativeNumbers;
    }
    
    //Sliding Window
    private static int[] findFirstNegativeNumberInSubarrayOfSizeK(int[] a, int k) {
        int n = a.length;
        int[] firstNegativeNumbers = new int[n - k + 1];
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            if (a[windowEnd] < 0) {
                q.add(a[windowEnd]);
            }

            if (windowEnd - windowStart + 1 == k) { // Calculate result and Slide the window
                if (q.isEmpty()) {
                    firstNegativeNumbers[idx++] = 0;
                } else {
                    int num = q.peek();
                    firstNegativeNumbers[idx++] = num;

                    // Remove a[windowStart] from the queue since we need to slide the window now.
                    // But only if it was added to the queue previously
                    if (num == a[windowStart]) {
                        q.remove();
                    }
                }
                windowStart++; // Slide the window ahead
            }
        }

        return firstNegativeNumbers;
    }
    
}
