/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class FindLargestAndSmallestFromArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = new int[]{23, 34, 13, 64, 72, 90, 10, 15, 9, 27};
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }

        }
        System.out.println("MAX Number " + max);
        System.out.println("MIN Number " + min);
    }

}
