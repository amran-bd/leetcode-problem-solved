/*
 * Click https://iq.opengenus.org/longest-increasing-subsequence/
 */
package com.amran.solution;

import java.util.Arrays;

/**
 * Dynamic Programming
 *
 * @author Amran Hossain
 */
public class LongestIncreasingSubSequence {

    /*\
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
     */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        System.out.println(lengthLIS(nums));
    }

    //Dynamic Programming: O(n^2)
    public static int lengthLIS(int[] nums) {
        int len = nums.length;
        int[] LIS = new int[len];
        Arrays.fill(LIS, 1);
        for (int i = 1; i < len; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                // find the longest increasing subsequence that ends with `arr[j]`
                // where `arr[j]` is less than the current element `arr[i]`
                if (nums[i] > nums[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }
        // return longest increasing subsequence (having maximum length)
        /* Pick maximum of all LIS values */
        //for (i = 0; i < n; i++)
        //  if (max < lis[i])
        //    max = lis[i];
        //Or we can use java stream
        return Arrays.stream(LIS).max().getAsInt();
    }

    // Brute force: O(N^2)
    //Binary Search: O(nlogn)
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
