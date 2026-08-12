/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.amran.solution.agoda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amranhossain
 * 
 * The marketing team at CodeSignal would like to know how many users there are in 
 * each Coding Score range, so that they can share that information on our website. They've asked you to create a report containing that information.

Your Mission

As input, you are given a list of scores. Coding Score can be anywhere between 300 and 850. 
* For the purpose of this task, levels are defined in the following way:

Poor: 300-599
Fair: 600-699
Good: 700-749
Excellent: 750-799
Elite: 800+
Calculate how many users are there in each level, then return a list of strings where each string represents a 
* level and a number of users within that level, formatted like LevelName - Number. The levels should be sorted in 
* decreasing order of those numbers, omitting any levels that have no users. In case of a tie, the higher level should appear first.
* 
* For example, if you had this input...

  [330, 723, 730, 825]
...then you should return the following:

[
  'Good - 2',
  'Elite - 1',
  'Poor - 1'
]
 */
public class CalculateHowManyUsersAreThereInEachLevel {

    public static List<String> generateReport(int[] scores) {
        Map<String, Integer> levelCounts = new HashMap<>();
        
        for (int score : scores) {
            String level = getLevel(score);
            levelCounts.put(level, levelCounts.getOrDefault(level, 0) + 1);
        }
        
        List<String> result = new ArrayList<>();
        levelCounts.entrySet().stream()
            .sorted((entry1, entry2) -> {
                int compare = Integer.compare(entry2.getValue(), entry1.getValue());
                if (compare == 0) {
                    // If user count is the same, higher level comes first
                    return Integer.compare(getLevelValue(entry2.getKey()), getLevelValue(entry1.getKey()));
                }
                return compare;
            })
            .forEach(entry -> {
                result.add(entry.getKey() + " - " + entry.getValue());
            });
        
        return result;
    }
    
    // Helper method to determine the level based on the score
    private static String getLevel(int score) {
        if (score >= 800) {
            return "Elite";
        } else if (score >= 750) {
            return "Excellent";
        } else if (score >= 700) {
            return "Good";
        } else if (score >= 600) {
            return "Fair";
        } else {
            return "Poor";
        }
    }

    // Helper method to assign a numeric value to each level
    private static int getLevelValue(String level) {
        switch (level) {
            case "Elite":
                return 5;
            case "Excellent":
                return 4;
            case "Good":
                return 3;
            case "Fair":
                return 2;
            case "Poor":
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        int[] scores = {330, 723, 730, 825};
        List<String> report = generateReport(scores);
        
        for (String levelCount : report) {
            System.out.println(levelCount);
        }
    }
}