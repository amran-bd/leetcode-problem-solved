/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author amranhossain
 */
public class FindNthHighestSalary {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 95000),
                new Employee("Charlie", 75000),
                new Employee("David", 120000),
                new Employee("Emma", 85000),
                new Employee("Fred", 95000) // Duplicate high salary
        );

        int n = 1; // Change this value to find the 1st, 2nd, 3rd, etc. highest salary

        // Clean & simple Stream to get the Nth highest salary
        double nthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct() // Remove duplicate salaries
                .sorted(Comparator.reverseOrder()) // Sort highest to lowest
                .skip(n - 1) // Skip the top N-1 salaries
                .findFirst() // The first item left is the Nth highest
                .orElse(0.0);                      // Return 0.0 if N is out of bounds

        System.out.println(n + "rd Highest Salary: $" + nthHighestSalary);
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
