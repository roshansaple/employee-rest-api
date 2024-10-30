package com.crud.service;

import com.crud.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {

    public List<Employee> fetchAllEmployees() throws SQLException,ClassNotFoundException;
    public boolean addEmployee(Employee employee) throws SQLException,ClassNotFoundException;
    public boolean deleteEmployee(int id) throws SQLException,ClassNotFoundException;
    public boolean updateEmployee(Employee employee) throws SQLException,ClassNotFoundException;
    public Employee fetchEmployeeByID(int id) throws SQLException,ClassNotFoundException;
}
