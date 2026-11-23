package college;

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
        try(InputStream input = new FileInputStream("src/college/db.properties")) {
            props.load(input);
        } catch (Exception e) {
            System.out.println("Error loading properties: " + e);
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
