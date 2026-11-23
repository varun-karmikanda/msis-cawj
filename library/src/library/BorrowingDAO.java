package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowingDAO {
    public void issueBook(int borrowing_id, int book_id, int member_id){
        String check = "select copies_available from book where book_id = ?";
        String issue = "insert into borrowing (borrowing_id, book_id, member_id, issue_date, due_date) values (?, ?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY))";
        String update = "update book set copies_available = ? WHERE book_id = ?";

        try(Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            int available = 0;
            try(PreparedStatement checkPs = conn.prepareStatement(check);
                PreparedStatement issuePs = conn.prepareStatement(issue);
                PreparedStatement updatePs = conn.prepareStatement(update)
            ){
                checkPs.setInt(1, book_id);

                try(ResultSet res = checkPs.executeQuery()){
                    while(res.next()){
                        available = res.getInt("copies_available");
                    }
                    if(available < 1){
                        System.out.println("Book not available");
                        AppLogger.info("Book not available");
                        conn.rollback();
                        return;
                    }
                }

                issuePs.setInt(1, borrowing_id);
                issuePs.setInt(2, book_id);
                issuePs.setInt(3, member_id);

                int rows = issuePs.executeUpdate();
                System.out.println(rows + " book issued");
                AppLogger.info(rows + " book issued");

                updatePs.setInt(1, available - 1);
                updatePs.setInt(2, book_id);
                rows = updatePs.executeUpdate();
                System.out.println(rows + " book issued and updated");
                AppLogger.info(rows + " book issued and updated");

                conn.commit();


            } catch (Exception e) {
                conn.rollback();
                System.out.println("Error issuing book: " + e);
                AppLogger.info("Error issuing book: " + e);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }

    public void returnBook(int borrowing_id){
        String getBook = "select book_id from borrowing where borrowing_id = ?";
        String updateReturn = "update borrowing set return_date = CURDATE() where borrowing_id = ?";
        String update = "update book set copies_available = copies_available + 1  where book_id = ?";

        try(Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            try(PreparedStatement getBookPs = conn.prepareStatement(getBook);
                PreparedStatement updateReturnPs = conn.prepareStatement(updateReturn);
                PreparedStatement updatePs = conn.prepareStatement(update)
            ){
                int book_id = 0;

                getBookPs.setInt(1, borrowing_id);
                try(ResultSet res = getBookPs.executeQuery()){
                    while (res.next()){
                        book_id = res.getInt("book_id");
                    }
                    if(book_id == 0){
                        conn.rollback();
                        return;
                    }
                }

                updateReturnPs.setInt(1, borrowing_id);
                int rows = updateReturnPs.executeUpdate();
                System.out.println(rows + " book returned");
                AppLogger.info(rows + " book returned");

                updatePs.setInt(1, book_id);
                rows = updatePs.executeUpdate();
                System.out.println(rows + " book updated");
                AppLogger.info(rows + " book updated");

                conn.commit();

            } catch (Exception e) {
                conn.rollback();
                System.out.println("Error returning book: " + e);
                AppLogger.info("Error returning book: " + e);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            AppLogger.error("Error connecting to database: " + e);
        }
    }
}
