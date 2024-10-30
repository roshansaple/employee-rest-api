package com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/abcxyz";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
