/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amran.solution.javaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author amranhossain
 */
public class FindHighstSalaryEachDepartment {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 85000),
                new Employee("Bob", "IT", 95000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "HR", 65000),
                new Employee("Emma", "Finance", 90000)
        );

        // Group by department and find the employee with the maximum salary
        Map<String, Optional<Employee>> highestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        // Print the results cleanly
        highestSalaryByDept.forEach((dept, emp)
                -> System.out.println("Department: " + dept + " -> Highest Paid: " + emp.orElse(null))
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

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " ($" + salary + ")";
        }
    }
}
