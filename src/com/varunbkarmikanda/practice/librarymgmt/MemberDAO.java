package com.varunbkarmikanda.practice.librarymgmt;

import java.sql.*;

public class MemberDAO {
    public void addMember(String member_name, String email, String phone){
        String query = "INSERT INTO member(member_name, email, phone) values (?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, member_name);
            ps.setString(2, email);
            ps.setString(3, phone);

            int rows = ps.executeUpdate();
            System.out.println(rows + " member('s) inserted!");
        } catch (SQLException e) {
            System.out.println("Error adding member: " + e);
        }
    }

    public void modifyMember(int member_id, String member_name, String email, String phone){
        String query = "UPDATE member set member_name = COALESCE(?, member_name), email = COALESCE(?, email), phone = COALESCE(?, phone) WHERE member_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, member_name);
            ps.setString(2, email);
            ps.setString(3, phone);

            ps.setInt(4, member_id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " member('s) updated!");
        } catch (SQLException e) {
            System.out.println("Error modifying member: " + e);
        }
    }

    public void searchMember(String member_name){
        String query = "SELECT * FROM member WHERE member_name LIKE ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ) {
            ps.setString(1, "%" + member_name + "%");

            try(ResultSet res = ps.executeQuery()){
                boolean found = false;
                System.out.println("----- MEMBERS -----");
                while (res.next()){
                    found = true;
                    System.out.printf("| %-4d | %-15s | %-25s | %-15s |\n",
                            res.getInt("member_id"),
                            res.getString("member_name"),
                            res.getString("email"),
                            res.getString("phone"));
                }
                if(!found) System.out.println("Member not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error searching member: " + e);
        }
    }
}
