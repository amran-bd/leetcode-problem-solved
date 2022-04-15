/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.Arrays;

/**
 *
 * @author Amran Hossain
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 *
 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 *
 * Input: nums = [3,3], target = 6 Output: [0,1]
 *
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println("Output :"+ Arrays.toString(twoSum(nums, 9)));
        int[] nums2 = {3,2,4};
        System.out.println("Output :"+ Arrays.toString(twoSum(nums2, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int sum;
        int[] output = new int[2];
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum = nums[i - 1] + nums[j];
                if (sum == target) {
                    output[0] = i - 1;
                    output[1] = j;
                    break;
                }
            }

        }
        return output;
    }

}
