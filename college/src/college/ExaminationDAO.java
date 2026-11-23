package college;

import java.sql.*;

public class ExaminationDAO {
    public void addExamination(int exam_id, int subject_id, Date exam_date, double max_marks){
        String query = "INSERT INTO examination (exam_id, subject_id, exam_date, max_marks) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, exam_id);
                ps.setInt(2, subject_id);
                ps.setDate(3, exam_date);
                ps.setDouble(4, max_marks);

                int rows = ps.executeUpdate();
                System.out.println(rows + " examination('s) added successfully");
                AppLogger.info(rows + " examination('s) added successfully");
            } catch (Exception e) {
                System.out.println("Error adding examination " + e);
                AppLogger.error("Error adding examination: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }

    public void updateExamination(int exam_id, int subject_id, Date exam_date, double max_marks){
        String query = "UPDATE examination SET subject_id = ?, exam_date = ?, max_marks = ? WHERE exam_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, subject_id);
                ps.setDate(2, exam_date);
                ps.setDouble(3, max_marks);
                ps.setInt(4, exam_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " examination('s) updated successfully");
                AppLogger.info(rows + " examination('s) updated successfully");
            } catch (Exception e) {
                System.out.println("Error updating examination " + e);
                AppLogger.error("Error updating examination: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }
}
