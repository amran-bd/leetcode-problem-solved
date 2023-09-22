/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class PairsOfArraySumofEqual {

    static void pairs_value(int inputArray[], int inputNumber) {
        System.out.println("Pairs of elements and their sum : ");
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == inputNumber) {
                    System.out.println(inputArray[i] + " + " + inputArray[j] + " =  " + inputNumber);
                }
            }
        }
    }

    static void pairs_value2(int inputArray[], int number) {
        Arrays.sort(inputArray);

        int lowest = 0;
        int highest = inputArray.length - 1;
        while (lowest < highest) {
            if (inputArray[lowest] + inputArray[highest] == number) {
                System.out.println(inputArray[lowest] + " " + inputArray[highest] + " =" + number);
            }
            if (inputArray[lowest] + inputArray[highest] < number) {
                lowest++;
            } else {
                highest--;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        pairs_value(new int[]{2, 7, 4, -5, 11, 5, 20}, 15);

        pairs_value(new int[]{14, -15, 9, 16, 25, 45, 12, 8}, 30);
    }

}
