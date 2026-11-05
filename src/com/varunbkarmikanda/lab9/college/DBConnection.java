package com.varunbkarmikanda.lab9.college;

import java.sql.*;
import java.io.*;
import java.util.Properties;

public class DBConnection {
    private static final Properties props = new Properties();
    private static Connection conn = null;

    static{
        try(InputStream input = new FileInputStream("src/com/varunbkarmikanda/lab9/college/db.properties")) {
            props.load(input);

        } catch (Exception e) {
            System.out.printf("Database connection error: " + e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")
            );
        }
        return conn;
    }
}
