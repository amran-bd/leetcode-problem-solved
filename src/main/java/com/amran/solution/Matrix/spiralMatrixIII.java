package com.amran.solution.Matrix;

import java.util.Arrays;

/**
 *
 * @author amranhossain
 * 
 * You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

* Example 1:


Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]
Example 2:


Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

 */

public class spiralMatrixIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int rows = 1, cols=4, rStart = 0, cStart= 0;
        System.out.println(Arrays.deepToString(spiralMatrixGenerate(rows, cols, rStart, cStart)));
    }
    
    public static int[][] spiralMatrixGenerate(int rows, int cols, int rStart, int cStart){
        int totalLen = rows * cols;
        int[][] result = new int[totalLen][2];
        result[0] = new int[] { rStart, cStart };
        if (totalLen == 1) {
            return result;
        }

        int dist = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dirIdx = 0;
        int count = 1;
        
        while (count < totalLen) {
            if (dirIdx == 0 || dirIdx == 2) {
                dist++;
            }
            for (int i = 1; i <= dist; i++) {
                rStart += dirs[dirIdx][0];
                cStart += dirs[dirIdx][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[count++] = new int[] { rStart, cStart };
                    if (count == totalLen) {
                        return result;
                    }
                }
            }
            dirIdx = (dirIdx + 1) % 4;
        }

        return result;
    }
}
