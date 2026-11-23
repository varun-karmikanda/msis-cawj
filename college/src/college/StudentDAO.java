package college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(int student_id, String student_name, String program, int semester, String email){
        String query = "INSERT INTO student (student_id, student_name, program, semester, email) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, student_id);
                ps.setString(2, student_name);
                ps.setString(3, program);
                ps.setInt(4, semester);
                ps.setString(5, email);

                int rows = ps.executeUpdate();
                System.out.println(rows + " student('s) added successfully");
                AppLogger.info(rows + " student('s) added successfully");
            } catch (Exception e) {
                System.out.println("Error adding student " + e);
                AppLogger.error("Error adding student: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }

    public void updateStudent(int student_id, String student_name, String program, int semester, String email){
        String query = "UPDATE student SET student_name = ?, program = ?, semester = ?, email = ? WHERE student_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, student_name);
                ps.setString(2, program);
                ps.setInt(3, semester);
                ps.setString(4, email);
                ps.setInt(5, student_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " student('s) updated successfully");
                AppLogger.info(rows + " student('s) updated successfully");
            } catch (Exception e) {
                System.out.println("Error updating student " + e);
                AppLogger.error("Error updating student: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }
}
