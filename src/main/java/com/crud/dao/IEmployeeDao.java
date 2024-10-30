package com.crud.dao;

import com.crud.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDao {

    public List<Employee> getAllEmployees() throws SQLException,ClassNotFoundException;
    public boolean addEmployee(Employee employee) throws SQLException,ClassNotFoundException;
    public boolean deleteEmployee(int id) throws SQLException,ClassNotFoundException;
    public Employee fetchEmployeeByID(int id) throws SQLException,ClassNotFoundException;
    public boolean updateEmployee(Employee employee)throws SQLException,ClassNotFoundException;
}
