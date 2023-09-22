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
public class FindTwoElementFromArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array_nums = {77, 77, 65, 65, 65, 77};
        System.out.println("Original Array: " + Arrays.toString(array_nums));
        int num1 = 77;
        int num2 = 65;

        System.out.println("Result: " + result(array_nums, num1, num2));
    }

    public static boolean result(int[] array_nums, int num1, int num2) {
        for (int number : array_nums) {
            boolean r = number != num1 && number != num2;
            if (r) {
                return false;
            }
        }
        return true;
    }

}
