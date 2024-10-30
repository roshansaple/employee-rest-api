package com.crud.service;

import com.crud.dao.EmployeeDao;
import com.crud.model.Employee;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeDao employeeDao;

	/*
	 * public EmployeeService(){ this.employeeDao = new EmployeeDao(); }
	 */
    
    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> fetchAllEmployees() throws SQLException,ClassNotFoundException{
        return employeeDao.getAllEmployees();
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDao.addEmployee(employee);

    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee fetchEmployeeByID(int id) throws SQLException, ClassNotFoundException {
        return employeeDao.fetchEmployeeByID(id);
       // return false;
    }
}
