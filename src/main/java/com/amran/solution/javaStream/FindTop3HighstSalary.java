/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindTop3HighstSalary {
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 95000),
            new Employee("Charlie", 75000),
            new Employee("David", 120000), 
            new Employee("Emma", 85000),
            new Employee("Fred", 60000)
        );

        // Clean & simple Stream to get the top 3 highest salaries
        List<Double> top3Salaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()                        // Removes duplicates to ensure 3 unique high values
                .sorted(Comparator.reverseOrder()) // Sorts descending (highest to lowest)
                .limit(3)                          // Keeps only the top 3 elements
                .collect(Collectors.toList());

        System.out.println("Top 3 Highest Salaries: " + top3Salaries);
    }

    static class Employee {

        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }
    }
}
