package com.crud.dao;

import com.crud.model.Employee;
import com.crud.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao implements IEmployeeDao {
    private static final String QUERY_SELECT_ALL = "SELECT * FROM abcxyz.employees";
    private static final String QUERY_FETCH_EMP_BY_ID = "SELECT * FROM abcxyz.employees WHERE employeeNumber = ?";


    /**
     * fetches all employees from the database.
     * the connection, statement, and result set are managed within a try-with-resources block
     * ensuring they are automatically closed.
     */

    @Override
    public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Employee emp = new Employee();
                emp.setId(resultSet.getInt("employeeNumber"));
                emp.setFirstName(resultSet.getString("firstName"));
                emp.setLastName(resultSet.getString("lastName"));
                emp.setEmail(resultSet.getString("email"));
                emp.setJobTitle(resultSet.getString("jobTitle"));

                employeeList.add(emp);
            }
        }
        return employeeList;
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {

        System.out.println(employee);
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        System.out.println("id = "+id);
        return false;
    }

    @Override
    public Employee fetchEmployeeByID(int id) throws SQLException, ClassNotFoundException {
        System.out.println("id = "+id);

        Employee emp = new Employee();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FETCH_EMP_BY_ID);
             //preparedStatement.setInt(1, id);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                //Employee emp = new Employee();
                emp.setId(resultSet.getInt("employeeNumber"));
                emp.setFirstName(resultSet.getString("firstName"));
                emp.setLastName(resultSet.getString("lastName"));
                emp.setEmail(resultSet.getString("email"));
                emp.setJobTitle(resultSet.getString("jobTitle"));


            }
        }
        return emp;

    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        System.out.println(employee);
        return false;
    }
}