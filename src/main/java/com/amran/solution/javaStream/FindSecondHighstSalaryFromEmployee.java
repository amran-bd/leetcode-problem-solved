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
public class FindSecondHighstSalaryFromEmployee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 60000),
                new Employee("David", 75000), // Duplicate highest
                new Employee("Emma", 45000)
        );

        // Clean & simple Stream to get the second highest salary
        double secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0.0); // Default value if list doesn't have 2 distinct elements

        System.out.println("Second Highest Salary: " + secondHighestSalary);
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
