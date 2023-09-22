/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.HashSet;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class FindCommonELmentFromTwoArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == (array2[j])) {
                    System.out.println("Common element is : " + (array1[i]));
                }
            }
        }
    }

    //For String 
//    public static void main(String[] args) {
//        String[] array1 = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};
//
//        String[] array2 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};
//
//        System.out.println("Array1 : " + Arrays.toString(array1));
//        System.out.println("Array2 : " + Arrays.toString(array2));
//        HashSet<String> set = new HashSet<String>();
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array2.length; j++) {
//                if (array1[i].equals(array2[j])) {
//                    set.add(array1[i]);
//                }
//            }
//        }
//        System.out.println("Common element : " + (set));     //OUTPUT : [THREE, FOUR, FIVE]
//    }

}
