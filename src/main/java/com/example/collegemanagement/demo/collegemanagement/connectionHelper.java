package com.example.collegemanagement.demo.collegemanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionHelper {
    public static Connection getconnection() {
        try {
            Connection conn = null;
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin",
                            "phpmyadmin", "root");

            return  conn;
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
        return null;
    }
    public static void closeconnection() {
        try {
            Connection conn = null;
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin",
                            "phpmyadmin", "root");

           conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }

    }
}
