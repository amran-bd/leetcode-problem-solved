/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.Arrays;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class ReplaceEveryElementWithGratest {

    static int[] next_greatest_num(int arr_nums[]) {
        int size = arr_nums.length;
        int max_from_right_num = arr_nums[size - 1];
        arr_nums[size - 1] = -1;

        for (int i = size - 2; i >= 0; i--) {
            int temp = arr_nums[i];
            arr_nums[i] = max_from_right_num;
            if (max_from_right_num < temp) {
                max_from_right_num = temp;
            }
        }
        return arr_nums;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nums[] = {45, 20, 100, 23, -5, 2, -6};
        int result[];
        System.out.println("Original Array ");
        System.out.println(Arrays.toString(nums));

        result = next_greatest_num(nums);
        System.out.println("The modified array:");
        System.out.println(Arrays.toString(result));
    }

}
