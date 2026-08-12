/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.agoda;

/**
 *
 * @author amranhossain
 * 
 * You are given an array of positive integers arr. You'd like to know how many triangles can be formed with side lengths equal to adjacent elements from arr.

Construct an array of integers of length arr.length - 2, where the ith element is equal to 1 if it's possible to form a triangle with side lengths arr[i], arr[i + 1], and arr[i + 2], otherwise 0.

Return the resulting array of integers.

Note: A triangle can be formed with side lengths a, b, and c if a + b > c, a + c > b, and b + c > a.
 */
public class HowManyTriangles {

    public static int[] countTriangles(int[] arr) {
        int n = arr.length;
        int[] result = new int[n - 2];

        for (int i = 0; i < n - 2; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int c = arr[i + 2];

            if (a + b > c && a + c > b && b + c > a) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7};
        int[] result = countTriangles(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
