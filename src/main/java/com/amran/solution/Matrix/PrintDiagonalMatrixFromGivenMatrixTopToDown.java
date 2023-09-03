
package com.amran.solution.Matrix;

import java.util.LinkedList;
import java.util.List;

/*
    Given an m x n matrix of characters, write a method that returns a
    String which contains the concatenation of all the matrix’s diagonals,
    from top to bottom, right to left.

For example, input

1 A 5 7 B N

2 B 6 8 K R

5 Q N 3 B 1

Output has to be: 1 A2 5B5 76Q B8N NK3 RB 1 as a result (with or without spaces, doesn’t matter)

1, 2A, 5b5,

Solutions Findings:

This matrix show why shift could be a solution for the problem

(0,0)		
(0,1)	(1,0)	
(0,2)	(1,1)	(2,0)
(0,3)	(1,2)	(2,1)
(0,4)	(1,3)	(2,2)
(0,5)	(1,4)	(2,3)
(1,5)	(2,4)
(2,5)
*/
public class PrintDiagonalMatrixFromGivenMatrixTopToDown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       char matrix[][] = new char[][]{
                {'1', 'A', '5', '7', 'B', 'N'},
                {'2', 'B', '6', '8', 'K', 'R'},
                {'5', 'Q', 'N', '3', 'B', '1'}
        };
        int m = 3, n = 6;
         System.out.println(diagonalMatrix(m, n, matrix));
    }
    
    public static String diagonalMatrix(int m, int n, char matrix[][]) {
        StringBuilder sb = new StringBuilder();
        int startRow = 0, endRow = m - 1, startCol = 0, endCol = n - 1, i, j;
        if (matrix.length == 0) {
            return sb.toString();
        }

        //Considering Row
        for (startRow = 0; startRow <=endCol; startRow++) {
            j = 0;
            i = startRow;
            while (j <= endRow && i >= 0) {
                sb.append(matrix[j][i]);
                i = i - 1;
                j = j + 1;
            }
            sb.append(" ");
        }

        //Considering Column
        for (startCol = 1; startCol <=endRow; startCol++) {
            i = startCol;
            j = n - 1;
            while (i <=endRow && j >= 0) {
                sb.append(matrix[i][j]);
                j = j - 1;
                i = i + 1;
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
