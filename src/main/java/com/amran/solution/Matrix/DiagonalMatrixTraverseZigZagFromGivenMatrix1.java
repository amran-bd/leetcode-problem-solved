package com.amran.solution.Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 
Example 1:


Input: mat = [
[1,2,3],
[4,5,6],
[7,8,9]
]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]

Complexity
Time complexity: O(m*n)
Space complexity: O(1)


 */
public class DiagonalMatrixTraverseZigZagFromGivenMatrix1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int m = 3, n = 3;
        System.out.println(Arrays.toString(TraverseDiagonalMatrix(m, n, matrix)));
    }

    public static int[] TraverseDiagonalMatrix(int m, int n, int matrix[][]) {
        int[] ans = new int[m * n];
        int index = 0;

        int i = 0;
        int j = 0;
        ans[index++] = matrix[i][j];

        boolean isUp = true;
        while (index != ans.length) {
            if (isUp) {
                j += 1;

                while (j != 0 && i != m - 1) {
                    if (j < n) {
                        ans[index++] = matrix[i][j];
                    }
                    i++;
                    j--;
                }

                ans[index++] = matrix[i][j];
                isUp = false;
            } else {
                i += 1;

                while (i != 0 && j != n - 1) {
                    if (i < m) {
                        ans[index++] = matrix[i][j];
                    }
                    i--;
                    j++;
                }

                ans[index++] = matrix[i][j];
                isUp = true;
            }
        }

        return ans;
    }
}
