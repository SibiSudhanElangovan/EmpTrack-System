package com.employee.management.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeeUtil {
    private static final String URL =  "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USERNAME = "system";
    private static final String PASSWORD = "system";

    // Get DB connection
    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Example: salary formatting
    public static String formatSalary(double salary) {
        return String.format("%.2f", salary);
    }
}
