/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.Arrays;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class CyclicallyRotateFromArray {

    static int arra[] = new int[]{10, 20, 30, 40, 50, 60};

    static void rotate_array() {
        int a = arra[arra.length - 1], i;
        for (i = arra.length - 1; i > 0; i--) {
            arra[i] = arra[i - 1];
        }
        arra[0] = a;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Original arraay:");
        System.out.println(Arrays.toString(arra));

        rotate_array();

        System.out.println("Rotated arraay:");
        System.out.println(Arrays.toString(arra));
    }

}
