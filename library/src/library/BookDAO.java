package library;

import java.sql.*;

public class BookDAO {
    public void addBook(int book_id, String isbn, String title, String author, int total_copies, int copies_available){
        String query = "insert into book (book_id, isbn, title, author, total_copies, copies_available) values (?, ?, ?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setInt(1, book_id);
                ps.setString(2, isbn);
                ps.setString(3, title);
                ps.setString(4, author);
                ps.setInt(5, total_copies);
                ps.setInt(6, copies_available);

                int rows = ps.executeUpdate();
                System.out.println(rows + " book added successfully");
                AppLogger.info(rows + " book added successfully");
            } catch (Exception e){
                System.out.println("Error adding book: " + e);
                AppLogger.error("Error adding book: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }

    public void updateBook(int book_id, String isbn, String title, String author, int total_copies, int copies_available){
        String query = "update book set isbn = ?, title = ?, author = ?, total_copies = ?, copies_available = ? WHERE book_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, isbn);
                ps.setString(2, title);
                ps.setString(3, author);
                ps.setInt(4, total_copies);
                ps.setInt(5, copies_available);
                ps.setInt(6, book_id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " book updated successfully");
                AppLogger.info(rows + " book updated successfully");
            } catch (Exception e){
                System.out.println("Error updating book: " + e);
                AppLogger.error("Error updating book: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }

    public void searchBook(String title){
        String query = "select * from book where title like ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, "%" + title + "%");

            try(ResultSet res = ps.executeQuery()){
                System.out.println("----- BOOKS -----");
                while (res.next()){
                    System.out.println(res.getString("book_id") + " | " + res.getString("title"));
                }

                System.out.println("book searched successfully");
                AppLogger.info("book searched successfully");
            } catch (Exception e) {
                System.out.println("Error searching book: " + e);
                AppLogger.error("Error searching book: " + e);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }
}
