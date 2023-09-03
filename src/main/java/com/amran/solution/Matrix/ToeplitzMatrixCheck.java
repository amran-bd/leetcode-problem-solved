/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.Matrix;

/**
 *
 * @author amranhossain
 *
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise,
 * return false.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same elements.
 *
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]] Output: true Explanation: In
 * the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]",
 * "[3, 3]", "[4]". In each diagonal all elements are the same, so the answer is
 * True.
 */
public class ToeplitzMatrixCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        //Instead of keeping track of every number in each diagonal, 
        //just check if the previous number in the diagonal is the same.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Make sure to check if i + 1 and j + 1 is within the matrix.
                // If not, there will be IndexOutOfBound error.
                if (i + 1 < m && j + 1 < n && 
                        matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
