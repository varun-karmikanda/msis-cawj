package com.varunbkarmikanda.lab9.college;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExaminationDAO {
    public void addExamination(int exam_id, int subject_id, Date exam_date, double max_marks){
        String query = "insert into examination(exam_id, subject_id, exam_date, max_marks) values (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, exam_id);
                ps.setInt(2, subject_id);
                ps.setDate(3, exam_date);
                ps.setDouble(4, max_marks);

                int rows = ps.executeUpdate();
                System.out.println(rows + " examination('s) added!");
                AppLogger.info("Examination added: Exam ID: " + exam_id + ", Subject ID: " + subject_id + ", Exam Date: " + exam_date + ", Max Marks: " + max_marks);

            } catch (Exception e){
                System.out.println("Error adding examination: " + e);
                AppLogger.error("Error adding examination: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when adding examination: " + e);
            AppLogger.error("Database error when adding examination: " + e);
        }
    }

    public void updateExamination(int exam_id, int subject_id, Date exam_date, double max_marks){
        String query = "UPDATE examination set exam_date = ?, max_marks = ? WHERE exam_id = ? AND subject_id = ?";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setDate(1, exam_date);
                ps.setDouble(2, max_marks);
                ps.setInt(3, exam_id);
                ps.setInt(4, subject_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " examination('s) updated!");
                AppLogger.info("Examination updated: Exam ID: " + exam_id + ", Subject ID: " + subject_id + ", Exam Date: " + exam_date + ", Max Marks: " + max_marks);

            } catch (Exception e){
                System.out.println("Error updating examination: " + e);
                AppLogger.error("Error updating examination: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when updating examination: " + e);
            AppLogger.error("Database error when updating examination: " + e);
        }
    }
}
