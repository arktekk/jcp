package demo.jdbc;

import java.sql.*;
import java.math.*;
import java.io.*;

public class TransactionDemo {

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

        // Execute some INSERT statements in a transaction.
        Statement st = null;
        try {
            // Disable auto-commit
            cn.setAutoCommit(false);

            st = cn.createStatement();

            // Execute some INSERT statements
            st.executeUpdate("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES ('Bill',     10000, 'Flowerpot 1')");
            st.executeUpdate("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES ('Ben',      20000, 'Flowerpot 2')");

            // Ask user whether they want to commit or rollback
            System.out.println("Inserted 2 new rows into table. Do you want to commit (y/n)? ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String answer = br.readLine();

            if (answer.charAt(0) == 'y') {
                cn.commit();
            } else {
                cn.rollback();
            }

        } catch (SQLException e) {
            System.out.println("Error executing INSERT statement: " + e);
            try {
                cn.rollback();
            } catch (SQLException ex) {
            }
        } catch (IOException e) {
            System.out.println("Error reading from console: " + e);
            try {
                cn.rollback();
            } catch (SQLException ex) {
            }
        } finally {
            try {
                cn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
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
