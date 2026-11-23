package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    public void addMember(int member_id, String member_name, String email, String phone){
        String query = "insert into member (member_id, member_name, email, phone) values (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, member_id);
                ps.setString(2, member_name);
                ps.setString(3, email);
                ps.setString(4, phone);

                int rows = ps.executeUpdate();
                System.out.println(rows + " member added successfully");
                AppLogger.info(rows + " member added successfully");
            } catch (Exception e){
                System.out.println("Error adding member: " + e);
                AppLogger.error("Error adding member: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }

    public void updateMember(int member_id, String member_name, String email, String phone){
        String query = "update member set member_name = ?, email = ?, phone = ? WHERE member_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, member_name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setInt(4, member_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " member updated successfully");
                AppLogger.info(rows + " member updated successfully");
            } catch (Exception e){
                System.out.println("Error updating member: " + e);
                AppLogger.error("Error updating member: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }

    public void searchMember(String member_name){
        String query = "select * from member where member_name like ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, "%" + member_name + "%");

            try(ResultSet res = ps.executeQuery()){
                System.out.println("----- MEMBER -----");
                while (res.next()){
                    System.out.println(res.getString("member_id") + " | " + res.getString("member_name"));
                }

                System.out.println("member searched successfully");
                AppLogger.info("member searched successfully");
            } catch (Exception e) {
                System.out.println("Error searching member: " + e);
                AppLogger.error("Error searching member: " + e);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }
}
