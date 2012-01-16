package demo.jdbc;

import java.sql.*;

public class CallableStatementDemo {

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

        // Call a stored procedure.
        try {
            CallableStatement cs = cn.prepareCall(
                    "{? = call getRegionInfo(?,?) }");

            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, "Wales");
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.execute();

            System.out.println("Number of emps in Wales: " + cs.getInt(1));
            System.out.println("Average salary is £" + cs.getBigDecimal(3));
        } catch (SQLException e) {
            System.out.println("Error executing INSERT, DELETE, or UPDATE statement: " + e);
        }
    }
}
