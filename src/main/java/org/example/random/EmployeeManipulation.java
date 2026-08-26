package org.example.random;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


class Employee {

    private int id;
    private BigDecimal salary;
    private String department;
    private String name;

    public Employee(int id, BigDecimal salary, String department, String name) {
        this.id = id;
        this.salary = salary;
        this.department = department;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class EmployeeManipulation {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, new BigDecimal(1000), "IT", "John"),
                new Employee(2, new BigDecimal(2000), "HR", "Jane"),
                new Employee(1, new BigDecimal(1000), "IT", "John"),
                new Employee(2, new BigDecimal(2000), "HR", "Jane"),
                new Employee(3, new BigDecimal(8000), "OPERATIONS", "Daniel"),
                new Employee(4, new BigDecimal(10000), "FINANCE", "Mark"),
                new Employee(5, new BigDecimal(12000), "FINANCE", "Mark"),
                new Employee(6, new BigDecimal(3000), "HR", "Robert")
        );

        Set<Integer> empSet = new HashSet<>();

        Map<String, Employee> highestSalaryEmployeePerDepartment = employeeList.stream()
                .filter(e -> empSet.add(e.getId()))
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(e->e.getSalary())),Optional::get)));

        highestSalaryEmployeePerDepartment.forEach((k,v) -> System.out.println(k + " " +v.getId() + " " +v.getName() + " " +v.getSalary()));

    }
}


