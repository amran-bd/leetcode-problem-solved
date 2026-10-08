/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindEmpGroupByDepartment {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 85000),
                new Employee("Bob", "IT", 95000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "HR", 65000),
                new Employee("Emma", "Finance", 90000)
        );

        // Group employees by their department name
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the grouped result cleanly
        employeesByDept.forEach((dept, empList)
                -> System.out.println("Department: " + dept + " -> Employees: " + empList)
        );
    }

    static class Employee {

        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
