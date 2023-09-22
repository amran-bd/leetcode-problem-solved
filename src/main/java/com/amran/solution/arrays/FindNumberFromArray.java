/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class FindNumberFromArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = new int[] {1,2,24,6,8};
        int findValue =  2;
        for(int i = 0; i<array.length; i++){
            if(findValue == array[i]){
                System.out.println("Valu Found");
            }
        }
    }
    
}
