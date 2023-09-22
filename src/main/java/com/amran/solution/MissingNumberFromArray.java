/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author amranhossain
 */
public class MissingNumberFromArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5,6, 7};
        int miss = getMissing(a);
        System.out.println(miss);
    }

    static int getMissing(int a[]) {
        int n = a.length-1, nextVal = 0;
        Arrays.sort(a);
        for(int i=0; i<n; i++){
            nextVal = a[i+1] - a[i];
            if(nextVal != 1){
                return a[i] +1;
            }
        }
        return 0;
    }

}
