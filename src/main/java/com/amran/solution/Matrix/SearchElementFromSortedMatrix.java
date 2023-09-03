package com.amran.solution.Matrix;

/**
 *
 * @author amranhossain
 *
 * You are given an m x n integer matrix matrix with the following two
 * properties:
 *
 * Each row is sorted in non-decreasing order. The first integer of each row is
 * greater than the last integer of the previous row. Given an integer target,
 * return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 Output:
 * true
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13 Output:
 * false
 */
public class SearchElementFromSortedMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Test Case-1
        int matrix[][] = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int targetValue = 3;
        System.out.println(searchSortedMatrix(matrix, targetValue));

        //Test Case-2
        int matrix2[][] = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int targetValue2 = 13;
        System.out.println(searchSortedMatrix(matrix2, targetValue2));
    }

    public static boolean searchSortedMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
            if (target == matrix[i][j]) {
                return Boolean.TRUE;
            } else if (target < matrix[i][j]) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }

        return Boolean.FALSE;
    }

}
