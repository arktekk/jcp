package demo.jdbc;

import java.sql.*;

public class ScrollableUpdatableDemo {

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

        // Perform a scrollable update.
        try {
            Statement st = cn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery(
                    "SELECT Name, Region FROM Employees WHERE REGION='London'");

            rs.afterLast();
            while (rs.previous() != false) {
                System.out.println("Employee name: " + rs.getString("Name"));
                rs.updateString("Region", "Bracknell");
                rs.updateRow();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
