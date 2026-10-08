/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 *
 * @author amranhossain
 */
public class FindSumAndAverageSalary {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 90000),
                new Employee("Charlie", 60000),
                new Employee("David", 110000),
                new Employee("Emma", 40000)
        );

        // Capture all summary statistics in one line
        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        // Extract sum and average cleanly
        double totalSalarySum = stats.getSum();
        double averageSalary = stats.getAverage();

        System.out.println("Total Salary Sum: $" + totalSalarySum);
        System.out.println("Average Salary: $" + averageSalary);
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
