package library;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection != null)
                System.out.println("Success");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            return;
        }

        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        BorrowingDAO borrowingDAO = new BorrowingDAO();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add book");
            System.out.println("2. Update book");
            System.out.println("3. Search book");
            System.out.println("4. Add member");
            System.out.println("5. Update member");
            System.out.println("6. Search member");
            System.out.println("7. Issue book");
            System.out.println("8. Return book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.print("Book id: ");
                        int bookId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Total copies: ");
                        int total = Integer.parseInt(sc.nextLine().trim());
                        bookDAO.addBook(bookId, isbn, title, author, total, total);
                        break;

                    case 2:
                        System.out.print("Book id to update: ");
                        int ubId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("New ISBN: ");
                        String uIsbn = sc.nextLine();
                        System.out.print("New title: ");
                        String uTitle = sc.nextLine();
                        System.out.print("New author: ");
                        String uAuthor = sc.nextLine();
                        System.out.print("New total copies: ");
                        int uTotal = Integer.parseInt(sc.nextLine().trim());
                        bookDAO.updateBook(ubId, uIsbn, uTitle, uAuthor, uTotal, uTotal);
                        break;

                    case 3:
                        System.out.print("Search book by keyword: ");
                        bookDAO.searchBook(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Member id: ");
                        int memberId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();
                        memberDAO.addMember(memberId, name, email, phone);
                        break;

                    case 5:
                        System.out.print("Member id to update: ");
                        int umId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("New name: ");
                        String uName = sc.nextLine();
                        System.out.print("New email: ");
                        String uEmail = sc.nextLine();
                        System.out.print("New phone: ");
                        String uPhone = sc.nextLine();
                        memberDAO.updateMember(umId, uName, uEmail, uPhone);
                        break;

                    case 6:
                        System.out.print("Search member by keyword: ");
                        memberDAO.searchMember(sc.nextLine());
                        break;

                    case 7:
                        System.out.print("Borrowing id: ");
                        int borrowingId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Book id: ");
                        int issueBookId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Member id: ");
                        int issueMemberId = Integer.parseInt(sc.nextLine().trim());
                        borrowingDAO.issueBook(borrowingId, issueBookId, issueMemberId);
                        break;

                    case 8:
                        System.out.print("Borrowing id to return: ");
                        int returnId = Integer.parseInt(sc.nextLine().trim());
                        borrowingDAO.returnBook(returnId);
                        break;

                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        sc.close();
    }


//    public static void main(String[] args) {
//        try(Connection connection = DBConnection.getConnection()) {
//            if(connection != null)
//                System.out.println("Success");
//
//        } catch (SQLException e) {
//            System.out.println("Error");
//        }
//
//
//        BookDAO bookDAO = new BookDAO();
//        MemberDAO memberDAO = new MemberDAO();
//        BorrowingDAO borrowingDAO = new BorrowingDAO();
//
//        bookDAO.addBook(3, "BOOK003", "C", "Paul", 5, 5);
//        bookDAO.updateBook(3, "BOOK003", "C programming", "Joel", 25, 25);
//        bookDAO.searchBook("py");
//
//        memberDAO.addMember(3, "John", "john@gmail.com", "8888888888");
//        memberDAO.updateMember(3, "John", "john@gmail.com", "7777776666");
//        memberDAO.searchMember("va");
//
//        borrowingDAO.issueBook(4, 1, 2);
//        borrowingDAO.returnBook(4);
//    }
}
