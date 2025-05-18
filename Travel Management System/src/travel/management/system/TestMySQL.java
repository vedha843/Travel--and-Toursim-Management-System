package travel.management.system;

import java.sql.*;

public class TestMySQL {
    public static void main(String[] args) {
        System.out.println("Hello, MySQL Test!");
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tms", "root", "vedha17"
            );
            System.out.println("✅ Connected to database!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error while connecting: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
