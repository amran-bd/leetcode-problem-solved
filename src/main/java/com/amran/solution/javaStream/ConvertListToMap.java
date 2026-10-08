/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class ConvertListToMap {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice"),
                new Employee(102, "Bob"),
                new Employee(103, "Charlie")
        );

        // Convert List to Map using modern Streams
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId, // Key mapper function
                        Function.identity() // Value mapper function (returns the employee object itself)
                ));

        System.out.println("Resulting Map: " + employeeMap);
    }

    static class Employee {

        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "'}";
        }
    }

}
