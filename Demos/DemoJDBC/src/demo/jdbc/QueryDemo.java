package demo.jdbc;

import java.sql.*;
import java.math.*;

public class QueryDemo {

    public static void main(String[] args) {
        
        // Load JDBC/ODBC bridge driver
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC/ODBC driver: " + e);
        }


        // Connect to a database
        Connection cnEmps = null;
        try {
            cnEmps = DriverManager.getConnection("jdbc:odbc:Employees");
        } catch (SQLException e) {
            System.out.println("Error connecting to a database: " + e);
        }


        ResultSet rsEmps = null;
        try {
            // Execute a SQL query
            Statement st = cnEmps.createStatement();
            rsEmps = st.executeQuery("SELECT Name, Salary FROM Employees");

            // Process the results of the query, one row at a time
            while (rsEmps.next() != false) {
                
                String name = rsEmps.getString(1);
                BigDecimal salary = rsEmps.getBigDecimal(2);

                // String     name   = rsEmps.getString("Name");
                // BigDecimal salary = rsEmps.getBigDecimal("Salary");

                System.out.println("Name: " + name + "\tsalary: " + salary);
            }
            
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e);
        }

    }
}
