package library;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    public static final Properties props = new Properties();
    public static Connection conn = null;

    static {
        try(InputStream inputStream = new FileInputStream("src/library/db.properties")) {
            props.load(inputStream);
        } catch (Exception e) {
            System.out.println("Error couldn't find configurations");
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
