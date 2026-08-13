package com.amran.solution.arrays_dsa;

/**
 * @author Md Amran Hossain on 13/8/2026 AD
 * @Project leetcode-problem-solved
 */
public class FindLargestAndSecondLargestFromArray {

    public static void main(String[] args) {
        int[] array = {13,30,2,15,33};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                secondLargest = largest;
                largest = array[i];
            }else if (array[i] > secondLargest && array[i] != largest) {
                secondLargest = array[i];
            }
        }

        System.out.println("Largest "+ largest);
        System.out.println("Second largest "+ secondLargest);
    }
}

//Complexity BigO(n)