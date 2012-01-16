package demo.jdbc;

import java.sql.*;
import java.math.*;

public class PreparedStatementDemo {

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

        // Execute some prepared statements.
        try {
            // Create a prepared statement, to do some INSERTs
            PreparedStatement ps = cn.prepareStatement("INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES (?, ?, ?)");

            // Insert some rows
            ps.setString(1, "Thomas");
            ps.setBigDecimal(2, new BigDecimal(10000));
            ps.setString(3, "Wales");
            ps.executeUpdate();

            ps.setString(1, "Emily");
            ps.setBigDecimal(2, new BigDecimal(20000));
            ps.setString(3, "Wales");
            ps.executeUpdate();

            ps.setString(1, "Laura");
            ps.setBigDecimal(2, new BigDecimal(50000));
            ps.setString(3, "London");
            ps.executeUpdate();


            // Create a prepared statement, to do some UPDATEs
            ps = cn.prepareStatement("UPDATE Employees   SET Salary = Salary * ?    WHERE Region = ?");

            ps.setDouble(1, 1.25);
            ps.setString(2, "Wales");
            ps.executeUpdate();

            ps.setDouble(1, 1.10);
            ps.setString(2, "London");
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing INSERT, DELETE, or UPDATE statement: " + e);
        }



        // Display the new contents of the Employees table
        ResultSet rsEmps = null;
        try {
            Statement st = cn.createStatement();
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
