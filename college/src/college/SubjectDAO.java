package college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {
    public void addSubject(int subject_id, String subject_name, int credits, int semester){
        String query = "INSERT INTO subject (subject_id, subject_name, credits, semester) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1,subject_id);
                ps.setString(2, subject_name);
                ps.setInt(3, credits);
                ps.setInt(4, semester);

                int rows = ps.executeUpdate();
                System.out.println(rows + " subject('s) added successfully");
                AppLogger.info(rows + " subject('s) added successfully");
            } catch (Exception e) {
                System.out.println("Error adding subject" + e);
                AppLogger.error("Error adding subject" + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }

    public void updateSubject(int subject_id, String subject_name, int credits, int semester){
        String query = "UPDATE subject SET subject_name = ?, credits = ?, semester = ? WHERE subject_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, subject_name);
                ps.setInt(2, credits);
                ps.setInt(3, semester);
                ps.setInt(4, subject_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " subject('s) updated successfully");
                AppLogger.info(rows + " subject('s) updated successfully");
            } catch (Exception e) {
                System.out.println("Error updating subject" + e);
                AppLogger.info("Error updating subject" + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }
}
