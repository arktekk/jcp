package demo.jdbc;

import java.sql.*;

public class ResultSetMetaDataDemo {

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

        // Execute a query and get resultset metadata.
        try {
            Statement st = cn.createStatement();

            ResultSet rsEmps = st.executeQuery("SELECT * FROM Employees");
            ResultSetMetaData rsmd = rsEmps.getMetaData();

            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Col name: " + rsmd.getColumnName(i));
                System.out.println("Type: "     + rsmd.getColumnTypeName(i));
                System.out.println("Nullable? " + rsmd.isNullable(i));
            }
        } catch (SQLException e) {
            System.out.println("Error getting resultset metadata: " + e);
        }
    }
}
