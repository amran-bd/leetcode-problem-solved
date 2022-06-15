/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Amran Hossain
 */
public class FindMajorityElementFromArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println("" + majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        List<Integer> inputList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<Integer, Long> result
                = inputList.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        return Integer.getInteger(String.valueOf(getMaxValue(result)));
    }

    private static Long getMaxValue(Map<Integer, Long> map) {
        Map.Entry<Integer, Long> maxEntry = null;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }

    //Bourt Force
    public int majorityElement2(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }

}
