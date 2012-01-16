package demo.jdbc;

import java.sql.*;
import java.math.*;

public class InsertDeleteUpdateDemo {

    public static void main(String[] args) {
        
        // Set up a default JDBC driver and database name.
        String jdbcDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String databaseUri = "jdbc:odbc:Employees";

        if (args.length == 2) {
            jdbcDriver = args[0];
            databaseUri = args[1];
        }

        // Load JDBC driver.
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e);
        }

        // Connect to a database.
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(databaseUri);
        } catch (SQLException e) {
            System.out.println("Error connecting to a database: " + e);
        }

        // Execute some INSERT, DELETE, and UPDATE statements.
        Statement st = null;
        try {
            st = cn.createStatement();

            // Execute some INSERT statements
            st.executeUpdate("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES ('Ryan',     750000, 'Wales')");
            st.executeUpdate("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES ('Mark',     250000, 'Wales')");
            st.executeUpdate("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES ('Becks',  15000000, 'Italy')");
            st.executeUpdate("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES ('Fergie',  5000000, 'Manchester')");

            // Execute a DELETE statement
            int rowsAffected = st.executeUpdate("DELETE FROM Employees WHERE Salary > 750001");
            System.out.println("Rows deleted: " + rowsAffected);

            // Execute an UPDATE statement
            rowsAffected = st.executeUpdate("UPDATE Employees   SET Salary = Salary * 1.25   WHERE Region = 'Wales'");
            System.out.println("Rows updated: " + rowsAffected);


        } catch (SQLException e) {
            System.out.println("Error executing INSERT, DELETE, or UPDATE statement: " + e);
        }



        // Display the new contents of the Employees table
        ResultSet rsEmps = null;
        try {
            rsEmps = st.executeQuery("SELECT Name, Salary, Region FROM Employees");

            while (rsEmps.next() != false) {
                String name = rsEmps.getString("Name");
                BigDecimal salary = rsEmps.getBigDecimal("Salary");
                String region = rsEmps.getString("Region");

                System.out.println("Name: " + name + "\tsalary: " + salary + "\tRegion: " + region);
            }

        } catch (SQLException e) {
            System.out.println("Error executing SELECT statement: " + e);
        }

    }
}
