package student.jdbc;

import java.sql.*;
import java.io.*;

public class UseAccessDB {

    private static Connection connection = null;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            /*
             * Load the JDBC driver for Microsoft Access, and 
             * connect to the TestDB database.
             */





            // Display the main menu of options
            String choice = "";
            do {
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("1. Create Books table");
                System.out.println("2. Query all books");
                System.out.println("3. Insert new books");
                System.out.println("4. Execute raw SQL");
                System.out.println("5. Quit");
                System.out.println("\n====>");

                choice = br.readLine();

                if (choice.equals("1")) {
                    createTable();
                } else if (choice.equals("2")) {
                    queryData();
                } else if (choice.equals("3")) {
                    insertData();
                } else if (choice.equals("4")) {
                    executeRawSQL();
                }
            } while (!choice.equals("5"));

        } catch (SQLException ex) {
            System.out.println("Database exception: " + ex.getMessage());

        } catch (Exception ex) {
            System.out.println("General exception: " + ex.getMessage());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Exception closing connection: " + ex);
                }
            }
        }
    }

    public static void createTable() throws SQLException {
        /*
         * Execute a SQL CREATE TABLE statement, to create a new table named Books
         */

    
    }

    public static void queryData() throws SQLException {
        /*
         * Execute a SQL SELECT statement, to retrieve and display rows from the database
         */
    
    
    }

    public static void insertData() throws SQLException, IOException {
        /*
         * Execute SQL INSERT statements, to insert book data into the database
         */
    
    
    }

    public static void executeRawSQL() throws SQLException, IOException {
        /*
         * Allow the user to enter any SQL from the keyboard. Then execute the statement,
         * and extract metadata to process the results.
         */
    
    
    }
}
