package demo.jdbc;

import java.sql.*;

public class BatchUpdateDemo {

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

        // Do a batch update.
        try {
            DatabaseMetaData dbmd = cn.getMetaData();

            if (dbmd.supportsBatchUpdates()) {
                cn.setAutoCommit(false);

                Statement st = cn.createStatement();
                st.addBatch("INSERT INTO Employees (Name, Salary, Region) VALUES('Zak', 2000000, 'USA')");
                st.addBatch("INSERT INTO Employees (Name, Salary, Region) VALUES('Yul', 1500000, 'USA')");
                st.addBatch("INSERT INTO Employees (Name, Salary, Region) VALUES('Xeo', 1750000, 'USA')");
                st.addBatch("DELETE FROM Employees WHERE Salary > 1000000");

                int[] rowsAffected = st.executeBatch();
                cn.commit();

                for (int i = 0; i < rowsAffected.length; i++) {
                    System.out.println("Rows affected by statement [" + i + "]: " + rowsAffected[i]);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
