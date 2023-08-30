package com.amran.solution.Matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amranhossain Print matrix in spiral order
 *
 * Given an M × N integer matrix, print it in spiral order.
 *
 * For example:
 *
 * Input:
 *
 * [ 1 2 3 4 5 ]
 * [ 16 17 18 19 6 ] [ 15 24 25 20 7 ] [ 14 23 22 21 8 ] [ 13 12 11 10 9 ]
 *
 * Output:
 *
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 *
 * Complexity is O(n*m), Space Complexity O(1)
 */
public class PrintSpiralFormGivenMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4, 5},
        {16, 17, 18, 19, 6},
        {15, 24, 25, 20, 7},
        {14, 23, 22, 21, 8},
        {13, 12, 11, 10, 9}
        };
       
        
        char matrix2[][] = {
        {'a','b','c','d','e'},
        {'p','q','r','s','f'},
        {'o','x','y','t','g'},
        {'n','w','v','u','h'},
        {'m','l','k','j','i'}
        };
        int m=5, n=5;
        List<Integer> list = printSprialOrder(m, n, matrix);
        System.out.println(list);
    }

    public static List<Integer> printSprialOrder(int m, int n, int matrix[][]) {

         List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) {
            return result;
        }
        //int m = matrix.length, n = matrix[0].length;
        int startRow = 0, endRow = m - 1, startCol = 0, endCol = n - 1;
        

        while (startRow <= endRow && startCol <= endCol) {

            //Traverse Right
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;

            //Traversal Down
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;

            if (startRow <= endRow) {
                //Traverse Left
                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
            }
            endRow--;

            if (startCol <= endCol) {
                //Traverse Up
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
            }
            startCol++;

        }
        return result;
    }
}
