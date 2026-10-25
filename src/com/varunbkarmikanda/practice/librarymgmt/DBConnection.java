package com.varunbkarmikanda.practice.librarymgmt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final Properties props = new Properties();
    private static Connection conn = null;

    static {
        try(InputStream input = new FileInputStream("src/com/varunbkarmikanda/practice/librarymgmt/db.properties")){
            props.load(input);
        } catch (Exception e) {
            System.out.println("Error loading db properties: " + e);
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

    public static void close(){
        try {
           if(conn != null || !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing the db: " + e);
        }
    }
}
