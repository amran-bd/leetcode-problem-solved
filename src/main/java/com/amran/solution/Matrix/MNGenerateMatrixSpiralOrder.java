package com.amran.solution.Matrix;

import java.util.Arrays;

/**
 *
 * @author amranhossain You are given two integers m and n, which represent the
 * dimensions of a matrix.
 *
 * You are also given the head of a linked list of integers.
 *
 * Generate an m x n matrix that contains the integers in the linked list
 * presented in spiral order (clockwise), starting from the top-left of the
 * matrix. If there are remaining empty spaces, fill them with -1.
 *
 * Return the generated matrix.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0] Output:
 * [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]] Explanation: The diagram above shows
 * how the values are printed in the matrix. Note that the remaining spaces in
 * the matrix are filled with -1.
 *
 */
public class MNGenerateMatrixSpiralOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] head = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        int m = 3, n = 5;
        System.out.println(Arrays.deepToString(MNMatrixSpiralOrder(m, n,head)));
    }
    
    /*
    Procedure Code::
    
    	Define variables: rowStart=0, rowEnd=m-1, colStart=0 and colEnd=n-1
	Iterate the loop within valid boundaries of above variables
	//Right
	In rowStart row Fill all the column values(from list or -1) starting from colStart to colEnd
	increment the rowStart
	
	//Down
	In colEnd column fill all the values(from list or -1) starting from rowStart to rowEnd
	decrement the colEnd
	
	//Left
	This is a conditional Iteration
	If rowStart <= rowEnd then only fill all the column values(from list or -1) from colEnd to colStart in rowEnd row.
	decrement rowEnd
	
	//Up
	This is a conditional Iteration
	If colStart <= colEnd then only fill all the values(from list or -1) from rowEnd to rowStart in colStart column
	increment colStart
    */

    public int[][] MNMatrixSpiralOrder(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //right
            for (int i = colStart; i <= colEnd; i++) {
                if (head == null) {
                    mat[rowStart][i] = -1;
                } else {
                    mat[rowStart][i] = head.val;
                    head = head.next;
                }
            }
            rowStart++;
            //down
            for (int i = rowStart; i <= rowEnd; i++) {
                if (head == null) {
                    mat[i][colEnd] = -1;
                } else {
                    mat[i][colEnd] = head.val;
                    head = head.next;
                }
            }
            colEnd--;
            //left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    if (head == null) {
                        mat[rowEnd][i] = -1;
                    } else {
                        mat[rowEnd][i] = head.val;
                        head = head.next;
                    }
                }
            }
            rowEnd--;
            //up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    if (head == null) {
                        mat[i][colStart] = -1;
                    } else {
                        mat[i][colStart] = head.val;
                        head = head.next;
                    }
                }
            }
            colStart++;
        }
        return mat;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
