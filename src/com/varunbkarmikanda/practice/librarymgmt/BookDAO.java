package com.varunbkarmikanda.practice.librarymgmt;

import java.sql.*;

public class BookDAO {
    public void addBook(String isbn, String title, String author, int total_copies){
        String query = "INSERT INTO book(isbn, title, author, total_copies, available_copies) values (?, ?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setInt(4, total_copies);
            ps.setInt(5, total_copies);

            int rows = ps.executeUpdate();
            System.out.println(rows + " book('s) inserted!");
            AppLogger.info("Book added: ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Total Copies: " + total_copies);
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e);
            AppLogger.error("Error adding book: " + e);
        }
    }

    public void modifyBook(int book_id, String isbn, String title, String author, Integer total_copies, Integer available_copies){
        String query = "UPDATE book set isbn = COALESCE(?, isbn), title = COALESCE(?, title), author = COALESCE(?, author), total_copies = COALESCE(?, total_copies), available_copies = COALESCE(?, available_copies) WHERE book_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);

            ps.setObject(4, total_copies, Types.INTEGER);
            ps.setObject(5, available_copies, Types.INTEGER);

            ps.setInt(6, book_id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " book('s) updated!");
            AppLogger.info("Book updated: ID: " + book_id + ", ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Total Copies: " + total_copies + ", Available Copies: " + available_copies);
        } catch (SQLException e) {
            System.out.println("Error modifying book: " + e);
            AppLogger.error("Error modifying book: " + e);
        }
    }

    public void searchBook(String title){
        String query = "SELECT * FROM book WHERE title LIKE ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ) {
            ps.setString(1, "%" + title + "%");

            try(ResultSet res = ps.executeQuery()){
                boolean found = false;
                AppLogger.info("Searching for books with title: " + title);
                System.out.println("----- BOOKS -----");
                while (res.next()){
                    found = true;
                    System.out.printf("| %-4d | %-14s | %-40s | %-20s | %-4d | %-4d |\n",
                            res.getInt("book_id"),
                            res.getString("isbn"),
                            res.getString("title"),
                            res.getString("author"),
                            res.getInt("total_copies"),
                            res.getInt("available_copies"));
                    AppLogger.info("Found book: ID: " + res.getInt("book_id") + ", ISBN: " + res.getString("isbn") + ", Title: " + res.getString("title") + ", Author: " + res.getString("author") + ", Total Copies: " + res.getInt("total_copies") + ", Available Copies: " + res.getInt("available_copies"));
                }
                
                if(!found) {
                    AppLogger.info("Book not found: " + title);
                    System.out.println("Book not found!");
                }

            }

        } catch (SQLException e) {
            System.out.println("Error searching book: " + e);
            AppLogger.error("Error searching book: " + e);
        }
    }
}
