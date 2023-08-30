
package com.amran.solution.Matrix;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amranhossain Print matrix in spiral order
 *
 * Given an M × N integer matrix, print it in Diagonal order.
 *
 * For example:
 *
 * Input:
 *
 * [ 1 2 3 4 5 ]
 * [ 16 17 18 19 6 ] 
 * [ 15 24 25 20 7 ] 
 * [ 14 23 22 21 8 ] 
 * [ 13 12 11 10 9 ]
 *
 * Output:
 *
 * 1 
 * 16 2
 * 15 17 3
 * 14 24 18 4
 * 13 23 25 19 5
 * 12 22 20 6
 * 11 21 7
 * 10 8
 * 9
 *
 * Complexity is O(n*m), Space Complexity O(1)
 */
public class PrintDiagonalMatrixFromGivenMatrix {

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
        List<Integer> list = printDiagonalOrder(m, n, matrix);
        System.out.println(list);
    }
    
    public static List<Integer> printDiagonalOrder(int m, int n, int matrix[][]) {

         List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) {
            return result;
        }
        
        int startRow = 0, endRow = m - 1, startCol = 0, endCol = n - 1, j, i;
        
        //For Consider Rows
        for(startRow=0; startRow<=endRow; startRow++){
            i = startRow;
            j = 0;
            while(i>=0){
                //result.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
                i = i -1;
                j = j+1;
            }
        }
        
        //For Consider Columns
        for(startCol = 1; startCol <=endCol; startCol++){
            i = m-1;
            j = startCol;
            while (j<=n-1){
                //result.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
                i = i -1;
                j = j+1;
            }
        }
        return result;
    }
}
