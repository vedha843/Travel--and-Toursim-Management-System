/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package travel.management.system;

import java.sql.*;

public class Conn {
    public Connection c;  // 🔓 make it accessible
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms", "root", "vedha17");
            s = c.createStatement();
            System.out.println("✅ Database connected!");
        } catch (Exception e) {
            System.out.println("❌ Error while connecting: " + e.getMessage());
            e.printStackTrace(); // 👈 Shows exact error cause
        }
    }
}

