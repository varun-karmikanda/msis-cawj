package com.varunbkarmikanda.lab9.college;

import java.sql.*;

public class ResultDAO {
    public void addMarks(int student_id, int exam_id, double marks_obtained, String grade){
        String query = "insert into result(student_id, exam_id, marks_obtained, grade) values (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, student_id);
                ps.setInt(2, exam_id);
                ps.setDouble(3, marks_obtained);
                ps.setString(4, grade);

                int rows = ps.executeUpdate();
                System.out.println(rows + " result('s) added!");
                AppLogger.info("Result added: Student ID: " + student_id + ", Exam ID: " + exam_id + ", Marks Obtained: " + marks_obtained + ", Grade: " + grade);

            } catch (Exception e){
                System.out.println("Error adding result: " + e);
                AppLogger.error("Error adding result: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when adding result: " + e);
            AppLogger.error("Database error when adding result: " + e);
        }
    }

    public void updateMarks(int student_id, int exam_id, double marks_obtained, String grade){
        String query = "UPDATE result set marks_obtained = ?, grade = ? WHERE student_id = ? AND exam_id = ?";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setDouble(1, marks_obtained);
                ps.setString(2, grade);
                ps.setInt(3, student_id);
                ps.setInt(4, exam_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " result('s) updated!");
                AppLogger.info("Result updated: Student ID: " + student_id + ", Exam ID: " + exam_id + ", Marks Obtained: " + marks_obtained + ", Grade: " + grade);

            } catch (Exception e){
                System.out.println("Error updating result: " + e);
                AppLogger.error("Error updating result: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when updating result: " + e);
            AppLogger.error("Database error when updating result: " + e);
        }
    }

    public void subjectWiseAvg(){
        String query = "SELECT s.subject_name, AVG(r.marks_obtained) AS avg_marks FROM result r, examination e, subject s WHERE r.exam_id = e.exam_id AND e.subject_id = s.subject_id GROUP BY s.subject_id, s.subject_name;";
        String line = "+--------------------------------+-----------+";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()
        ) {

            try(ResultSet res = stmt.executeQuery(query)){
                System.out.println("\nSubject-wise Average Marks");
                System.out.println(line);
                System.out.printf("| %-30s | %9s |%n", "Subject", "Average");
                System.out.println(line);
                while (res.next()){
                    System.out.printf("| %-30s | %9.2f |%n", res.getString("subject_name"), res.getDouble("avg_marks"));
                }
                    System.out.println(line);
                AppLogger.info("Subject wise average marks fetched successfully.");
            }

        } catch (SQLException e) {
            System.out.printf("Database error when when fetching the average: " + e);
            AppLogger.error("Database error when when fetching the average: " + e);
        }
    }

    public void highestScoringStudent(){
        String query = "SELECT student_id, SUM(marks_obtained) AS total FROM result GROUP BY student_id ORDER BY total DESC LIMIT 1;";
        String line = "+------------+-------------+";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()
        ) {

            try(ResultSet res = stmt.executeQuery(query)){
                System.out.println("\nHighest Scoring Student");
                System.out.println(line);
                System.out.printf("| %-10s | %11s |%n", "Student ID", "Total Marks");
                System.out.println(line);
                while (res.next()){
                    System.out.printf("| %10d | %11.2f |%n", res.getInt("student_id"), res.getDouble("total"));
                }
                System.out.println(line);
                AppLogger.info("Highest scoring student fetched successfully.");
            }

        } catch (SQLException e) {
            System.out.printf("Database error when when fetching the max: " + e);
            AppLogger.error("Database error when when fetching the max: " + e);
        }
    }
}
