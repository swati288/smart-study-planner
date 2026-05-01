package com.planner;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/marksheetdb"; // your DB name
            String user = "root";
            String pass = "root"; // your MySQL password

            con = DriverManager.getConnection(url, user, pass);

            System.out.println("DB Connected Successfully");

        } catch (Exception e) {
            System.out.println("DB Failed: " + e);
        }

        return con;
    }
}