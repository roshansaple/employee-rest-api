package com.crud.controller;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> printAllEmployees() {
    	List<Employee> employeeList = new ArrayList<>();
        try {
        	employeeList = employeeService.fetchAllEmployees();

        	employeeList.forEach(
                    emp -> System.out.println(emp.getId() + "-" + emp.getFirstName() + "-" + emp.getLastName()));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occured while fetching employees:" + e.getMessage());
            e.printStackTrace();
        }
        
        return employeeList;
    }

    public Employee printEmployeesByID(int id) {
        Employee emp = null;
        try {
            emp = employeeService.fetchEmployeeByID(id);

             System.out.println(emp.getId() + "-" + emp.getFirstName() + "-" + emp.getLastName());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occured while fetching employees:" + e.getMessage());
            e.printStackTrace();
        }
        return emp;
    }

    public void addEmployee(Employee employee) {
        try {
            boolean flag = employeeService.addEmployee(employee);

            if (flag)
                System.out.println("Employee added successfully");
            else
                System.out.println("Employee not added");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteEmployee(int id) {
        try {
            boolean flag = flag = employeeService.deleteEmployee(id);
            if (flag)
                System.out.println("Employee delete successfully");
            else
                System.out.println("Employee not delete");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            boolean flag =  employeeService.updateEmployee(employee);

            if (flag)
                System.out.println("Employee updated successfully");
            else
                System.out.println("Employee update failed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
