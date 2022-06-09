/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

/**
 *
 * @author Amran Hossain
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        int nums2[] = {2,7,9,3,1};
        
        System.out.println(rob2(nums));
        System.out.println(rob2(nums2));
    }

    public static int rob2(int[] nums) {
        int n = nums.length;
        //If the array contains only one element, return that element.
        if (n == 1) {
            return nums[0];
        } //If the array contains only two elements, return the max of the two elements.
        else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } //If the array contains more than two elements, calculate the max of (n-2) and (n-3) element and add it to the currrent element.
        else {
            nums[2] = Math.max(nums[0] + nums[2], nums[1]);
            for (int i = 3; i < n; i++) {
                //Here, we are calculating the max of (n-2) and (n-3) element and adding it to the currrent element.
                nums[i] += Math.max(nums[i - 2], nums[i - 3]);
            }
        }
        //Compare the last and second last element and return the maximum element between the two.
        return Math.max(nums[n - 1], nums[n - 2]);
    }
}
