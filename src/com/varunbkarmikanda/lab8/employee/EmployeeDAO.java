package com.varunbkarmikanda.lab8.employee;

import java.sql.*;

public class EmployeeDAO {
    public void insertEmployee(int id, String name, double salary){
        String query = "INSERT INTO employee(id, name, salary) VALUES(?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee('s) data inserted!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }

    public void displayEmployee(){
        String query = "SELECT * FROM employee";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query)
        ) {
            System.out.println("----- EMPLOYEE DATA -----");
            while (result.next()){
                System.out.printf("| %-4d | %-10s | %-10.2f |\n", result.getInt("id"), result.getString("name"), result.getDouble("salary"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }

    public void deleteEmployee(int id){
        String query = "DELETE  FROM employee WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee('s) data deleted!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }

    public void updateEmployee(int id, String name, Double salary){
        String query = "UPDATE employee set name = COALESCE(?, name), salary = COALESCE(?, salary) WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, name);
            ps.setObject(2, salary, Types.DOUBLE);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee('s) data updated!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}
