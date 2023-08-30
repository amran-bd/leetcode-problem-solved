package com.amran.solution.Matrix;

import java.util.Arrays;

/**
 *
 * @author amranhossain
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Example 1:
[1,2,3]
[8,9,4]
[7,6,5]

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 3
Output: [[1]]
* 
* Time Complexity
We are going to visit each indexes in matrix to add elements so time complexity is going to be: O(n*n).

Space Complexity
We are creating n*n matrix and adding elements into matrix, so space complexity is going to be: O(n*n).
 */
public class GenerateMatrixSpiralOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int n=1;
        System.out.println(Arrays.deepToString(generateSprialOrder(n)));
    }

    public static int[][] generateSprialOrder(int n) {

        int[][] arr = new int[n][n];
        if (n == 0) {
            return arr;
        }
        int startRow = 0, endRow = n - 1, startCol = 0, endCol = n - 1, val = 1;

        while (startRow <= endRow && startCol <= endCol) {

            //Traverse Right
            for (int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = val++;
            }
            startRow++;

            //Traversal Down
            for (int i = startRow; i <= endRow; i++) {
                arr[i][endCol] = val++;
            }
            endCol--;

            if (startRow <= endRow && startCol <= endCol) {
                //Traverse Left
                for (int i = endCol; i >= startCol; i--) {
                    arr[endRow][i] = val++;
                }
                endRow--;

                //Traverse Up
                for (int i = endRow; i >= startRow; i--) {
                    arr[i][startCol] = val++;
                }
                startCol++;

            }
             
        }
        return arr;
    }
}
