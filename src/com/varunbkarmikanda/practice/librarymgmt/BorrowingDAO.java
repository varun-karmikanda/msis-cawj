package com.varunbkarmikanda.practice.librarymgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowingDAO {
    public void issueBook(int book_id, int member_id, int copies){
        if(copies <= 0){
            System.out.println("Required at least one copy");
            return;
        }
        String checkAvailable = "SELECT available_copies FROM book WHERE book_id = ? FOR UPDATE";
        String insertBorrow = "INSERT INTO borrowing(book_id, member_id, issue_date, due_date) VALUES (?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY))";
        String updateBook = "UPDATE book set  available_copies =  available_copies - ? WHERE book_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try(PreparedStatement psCheckAvailability = conn.prepareStatement(checkAvailable);
                PreparedStatement psInsertBorrow = conn.prepareStatement(insertBorrow, PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement psUpdateBook = conn.prepareStatement(updateBook)
            ) {
                psCheckAvailability.setInt(1, book_id);
                try(ResultSet res = psCheckAvailability.executeQuery()){
                    if(!res.next()){
                        System.out.println("No book available with ID: " + book_id);
                        conn.rollback();
                        return;
                    }
                    int available = res.getInt("available_copies");
                    if(available < copies){
                        System.out.println("Only " + available + " are available.");
                        conn.rollback();
                        return;
                    }
                }

                List<Integer> borrowIds = new ArrayList<>();
                for (int i = 0; i < copies; i++) {
                    psInsertBorrow.setInt(1, book_id);
                    psInsertBorrow.setInt(2, member_id);
                    psInsertBorrow.executeUpdate();
                    try(ResultSet keys = psInsertBorrow.getGeneratedKeys()){
                        if(keys.next()) borrowIds.add(keys.getInt(1));
                    }
                }

                psUpdateBook.setInt(1, copies);
                psUpdateBook.setInt(2, book_id);
                psUpdateBook.executeUpdate();

                conn.commit();
                System.out.println(copies + " copy(ies) borrowed. Borrow IDs: " + borrowIds);
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Error issuing the book! " + e);
            }
        } catch (Exception e) {
            System.out.println("connection error issuing the book!" + e);
        }
    }

    public void returnBook(int borrow_id){
        String find = "SELECT book_id, return_date FROM borrowing WHERE borrow_id = ?";
        String setReturned = "UPDATE borrowing SET return_date = CURDATE() WHERE borrow_id = ?";
        String update = "UPDATE book SET available_copies = available_copies + 1 WHERE book_id = ?";

        try(Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try(PreparedStatement psFind = conn.prepareStatement(find);
                PreparedStatement psSetReturned = conn.prepareStatement(setReturned);
                PreparedStatement psUpdate = conn.prepareStatement(update)
            ) {
                int book_id;

                psFind.setInt(1, borrow_id);
                try(ResultSet res = psFind.executeQuery()){
                    if(!res.next()){
                        System.out.println("No borrowing with ID: " + borrow_id);
                        conn.rollback();
                        return;
                    }
                    if(res.getDate("return_date") != null){
                        System.out.println("Borrowing "  + borrow_id + " already returned");
                        conn.rollback();
                        return;
                    }
                    book_id = res.getInt("book_id");
                }

                psSetReturned.setInt(1, borrow_id);
                psSetReturned.executeUpdate();

                psUpdate.setInt(1, book_id);
                psUpdate.executeUpdate();

                conn.commit();
                System.out.println("Book returned successfully!");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Error returning book: " + e);
            }
        } catch (SQLException e) {
            System.out.println("DB Error: " + e);
        }
    }
}
