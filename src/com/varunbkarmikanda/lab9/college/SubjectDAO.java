package com.varunbkarmikanda.lab9.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {
    public void addSubject(int subject_id, String subject_name, int credits, int semester){
        String query = "insert into subject(subject_id, subject_name, credits, semester) values (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, subject_id);
                ps.setString(2, subject_name);
                ps.setInt(3, credits);
                ps.setInt(4, semester);

                int rows = ps.executeUpdate();
                System.out.println(rows + " subject('s) added!");
                AppLogger.info("Subject added: ID: " + subject_id + ", Name: " + subject_name + ", Credits: " + credits + ", Semester: " + semester);

            } catch (Exception e){
                System.out.println("Error adding subject: " + e);
                AppLogger.error("Error adding subject: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when adding subject: " + e);
            AppLogger.error("Database error when adding subject: " + e);
        }
    }

    public void updateSubject(int subject_id, String subject_name, int credits, int semester){
        String query = "UPDATE subject set subject_name = ?, credits = ?, semester = ? WHERE subject_id = ?";

        try(Connection conn = DBConnection.getConnection()) {

            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, subject_name);
                ps.setInt(2, credits);
                ps.setInt(3, semester);

                ps.setInt(4, subject_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " subject('s) updated!");
                AppLogger.info("Subject updated: ID: " + subject_id + ", Name: " + subject_name + ", Credits: " + credits + ", Semester: " + semester);

            } catch (Exception e){
                System.out.println("Error updating subject: " + e);
                AppLogger.error("Error updating subject: " + e);
            }

        } catch (SQLException e) {
            System.out.printf("Database error when updating subject: " + e);
            AppLogger.error("Database error when updating subject: " + e);
        }
    }
}
