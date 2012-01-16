package solution.jdbc;

import java.sql.*;
import java.math.*;
import java.io.*;

public class UseAccessDB {

    private static Connection connection = null;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            connection = DriverManager.getConnection("jdbc:odbc:TestDB");

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
        String sql = "CREATE TABLE Books ( " +
                "Isbn  INTEGER     NOT NULL, " +
                "Title VARCHAR(50) NOT NULL, " +
                "Price CURRENCY    NOT NULL, " +
                "CONSTRAINT PK_Books PRIMARY KEY (Isbn) " +
                ")";

        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        System.out.println("Books table created");
    }

    public static void queryData() throws SQLException {
        String sql = "SELECT Isbn, Title, Price FROM Books";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next() != false) {
            System.out.println("ISBN:  " + rs.getInt(1));
            System.out.println("Title: " + rs.getString(2));
            System.out.println("Price: " + rs.getBigDecimal(3));
            System.out.println();
        }
    }

    public static void insertData() throws SQLException, IOException {
        String sql = "INSERT INTO Books VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        int isbn;
        while (true) {
            System.out.println("Enter book ISBN (-1 to quit): ");
            isbn = Integer.parseInt(br.readLine());
            if (isbn == -1) {
                break;
            }

            System.out.println("Enter book title: ");
            String title = br.readLine();

            System.out.println("Enter price: ");
            BigDecimal price = new BigDecimal(br.readLine());

            ps.setInt(1, isbn);
            ps.setString(2, title);
            ps.setBigDecimal(3, price);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("The row was not inserted.");
            } else {
                System.out.println("The row was inserted.");
            }
        }
    }

    public static void executeRawSQL() throws SQLException, IOException {
        System.out.println("Please enter SQL statement: ");
        String sql = br.readLine();

        Statement st = connection.createStatement();
        st.execute(sql);

        ResultSet rs = st.getResultSet();
        if (rs != null) {
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Metadata for ResultSet");
            System.out.println("--------------------------------");

            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("\nFor column " + i + " ...");
                System.out.println("Column name:       " + rsmd.getColumnName(i));
                System.out.println("Column type:       " + rsmd.getColumnTypeName(i));
                System.out.println("Column class name: " + rsmd.getColumnClassName(i));
            }

            System.out.println("Data for ResultSet");
            System.out.println("--------------------------------");

            int rowNumber = 1;
            while (rs.next() != false) {
                System.out.println("\nFor row " + rowNumber++ + " ...");
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Column [" + i + "]=" + rs.getObject(i));
                }
            }
        } else {
            int rowsAffected = st.getUpdateCount();
            System.out.println("Rows affected: " + rowsAffected);
        }
    }
}
