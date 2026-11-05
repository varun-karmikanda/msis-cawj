package com.varunbkarmikanda.lab9.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(int student_id, String student_name, String program, int semester, String email){
        String query = "insert into student(student_id, student_name, program, semester, email) values (?, ?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, student_id);
                ps.setString(2, student_name);
                ps.setString(3, program);
                ps.setInt(4, semester);
                ps.setString(5, email);

                int rows = ps.executeUpdate();
                System.out.println(rows + " student('s) added!");
                AppLogger.info("Student added: ID: " + student_id + ", Name: " + student_name + ", Program: " + program + ", Semester: " + semester + ", Email: " + email);

            } catch (Exception e){
                System.out.println("Error adding student: " + e);
                AppLogger.error("Error adding student: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when adding student: " + e);
            AppLogger.error("Database error when adding student: " + e);
        }
    }

    public void updateStudent(int student_id, String student_name, String program, int semester, String email){
        String query = "UPDATE student set student_name = ?, program = ?, semester = ?, email = ? WHERE student_id = ?";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, student_name);
                ps.setString(2, program);
                ps.setInt(3, semester);
                ps.setString(4, email);
                ps.setInt(5, student_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " student('s) updated!");
                AppLogger.info("Student updated: ID: " + student_id + ", Name: " + student_name + ", Program: " + program + ", Semester: " + semester + ", Email: " + email);

            } catch (Exception e){
                System.out.println("Error updating student: " + e);
                AppLogger.error("Error updating student: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when updating student: " + e);
            AppLogger.error("Database error when updating student: " + e);
        }
    }
}

