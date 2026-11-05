package com.varunbkarmikanda.lab9.college;

import java.sql.*;
public class DBConnection {
    private static Connection conn = null;

    static{
        try {
            Class.forName(AppConfig.getRequired("db.driver"));
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Database driver not found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(
                    AppConfig.getRequired("db.url"),
                    AppConfig.getRequired("db.username"),
                    AppConfig.getRequired("db.password")
            );
        }
        return conn;
    }
}
