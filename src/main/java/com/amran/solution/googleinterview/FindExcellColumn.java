/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.googleinterview;

/**
 *
 * @author amranhossain
 * Find Excel column name for given index (naming from A-Z, AA-AZ, BA-BZ, .. . ZA-ZZ, AAA ...)
 * Leet code 168
 */
public class FindExcellColumn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(convertToTitle(2));
    }
    
    public static String convertToTitle(int columnNumber) {
        // Create an empty string for storing the characters...
        StringBuilder output = new StringBuilder();
        // Run a while loop while columnNumber is positive...
        while(columnNumber > 0){
            // Subtract 1 from columnNumber...
            columnNumber--;
            // Get current character by doing modulo of columnNumber by 26...
            char c = (char) (columnNumber % 26 + 'A');
            // Divide columnNumber by 26...
            columnNumber /= 26;
            // Append the character into output...
            output.append(c);
        }
        // Reverse the output string...
        // Bcause we have found characters from right to left...
        output.reverse();
        // Return the reversed string.
        return output.toString();
    }
    
}
