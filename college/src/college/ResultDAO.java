package college;

import java.sql.*;

public class ResultDAO {
    public void addResult(int student_id, int subject_id, double marks_obtained, String grade){
        String query = "INSERT INTO result (student_id, subject_id, marks_obtained, grade) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, student_id);
                ps.setInt(2, subject_id);
                ps.setDouble(3, marks_obtained);
                ps.setString(4, grade);

                int rows = ps.executeUpdate();
                System.out.println(rows + " result('s) added successfully");
                AppLogger.info(rows + " result('s) added successfully");
            } catch (Exception e) {
                System.out.println("Error adding result " + e);
                AppLogger.error("Error adding result: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }

    public void updateResult(int student_id, int subject_id, double marks_obtained, String grade){
        String query = "UPDATE result SET marks_obtained = ?, grade = ? WHERE student_id = ? AND subject_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setDouble(1, marks_obtained);
                ps.setString(2, grade);
                ps.setDouble(3, student_id);
                ps.setInt(4, subject_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " result('s) updated successfully");
                AppLogger.info(rows + " result('s) updated successfully");
            } catch (Exception e) {
                System.out.println("Error updating result " + e);
                AppLogger.error("Error updating result: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }

    public void subjectWiseAvg(){
        String query = "SELECT subject_id, AVG(marks_obtained) AS avg_marks FROM result GROUP BY subject_id";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()
        ) {
            try(ResultSet res = stmt.executeQuery(query)){
                System.out.println("Subject wise average marks");
                while (res.next()){
                    System.out.println(res.getString("subject_id") + "\t" + res.getString("avg_marks"));
                }
                AppLogger.info("Subject wise average marks fetched successfully");
            } catch (Exception e) {
                System.out.println("Error fetching average marks " + e);
                AppLogger.error("Error fetching average marks: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }

    public void highScoringStudent(){
        String query = "SELECT student_id, subject_id, marks_obtained FROM result r1 WHERE marks_obtained = (SELECT MAX(marks_obtained) FROM result r2 WHERE r2.subject_id = r1.subject_id);";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()
        ) {
            try(ResultSet res = stmt.executeQuery(query)){
                System.out.println("High scoring students");
                while (res.next()){
                    System.out.println(res.getString("student_id") + "\t" + res.getString("subject_id") + "\t" + res.getString("marks_obtained"));
                }
                AppLogger.info("High scoring students fetched successfully");
            } catch (Exception e) {
                System.out.println("Error fetching high scoring students " + e);
                AppLogger.error("Error fetching high scoring students: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
            AppLogger.error("Database connection error: " + e);
        }
    }
}
