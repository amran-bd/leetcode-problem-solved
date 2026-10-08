/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindEmployeesGreaterThanAverageSalary {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 90000),
                new Employee("Charlie", 60000),
                new Employee("David", 110000),
                new Employee("Emma", 40000)
        );

        // 1. Calculate the average salary using a stream
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average Salary: $" + averageSalary);

        // 2. Filter employees whose salary is greater than the average
        List<Employee> highEarners = employees.stream()
                .filter(emp -> emp.getSalary() > averageSalary)
                .collect(Collectors.toList());

        System.out.println("Employees earning above average: " + highEarners);
    }

    static class Employee {

        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " ($" + salary + ")";
        }
    }
}
