/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Md. Amran Hossain | Sr. Software Engineer | Helical-Inc
 */
public class SumofTwoElementGivenIntegerValue {

    public static ArrayList<Integer> two_sum_array_target(final List<Integer> a, int b) {

        HashMap<Integer, Integer> my_map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        for (int i = 0; i < a.size(); i++) {
            if (my_map.containsKey(a.get(i))) {
                int index = my_map.get(a.get(i));
                result.set(0, index);
                result.set(1, i);
                break;
            } else {
                my_map.put(b - a.get(i), i);
            }
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> my_array = new ArrayList<Integer>();
        my_array.add(1);
        my_array.add(2);
        my_array.add(4);
        my_array.add(5);
		my_array.add(6);
		int target = 6;
        ArrayList<Integer> result = two_sum_array_target(my_array, target);
        for(int i : result)
            System.out.print("Index: "+i + " ");
    }

}
