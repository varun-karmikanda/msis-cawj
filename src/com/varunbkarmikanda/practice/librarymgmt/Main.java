package com.varunbkarmikanda.practice.librarymgmt;

public class Main {
    public static void main(String[] args) {
        BookDAO book =  new BookDAO();
        MemberDAO member = new MemberDAO();
        BorrowingDAO borrowing = new BorrowingDAO();

//        book.addBook("978-1260440232", "Java: The Complete Reference", "Herbert Schildt", 5);
//        book.addBook("978-0078022159", "Database System Concepts", "Abraham Silberschatz", 4);
//        book.addBook("978-0132350884", "Clean Code", "Robert C. Martin", 3);
//        book.addBook("978-0262033848", "Introduction to Algorithms", "Thomas H. Cormen", 2);
//        book.addBook("978-0134685991", "Effective Java", "Joshua Bloch", 4);

//        book.modifyBook(1, null, "Java: The Complete Reference, 13th Ed", null, null, null);
//        book.modifyBook(2, null, null, null, 6, null);
//        book.modifyBook(3, "978-0132350885", null, "Robert Martin", null, null);
//        book.modifyBook(4, "978-0262033849", "Intro to Algorithms", "T. Cormen", 3, 2);
//
//        book.searchBook("Java");

//        member.addMember("Ananya Rao", "ananya.rao@mail.com", "9876543210");
//        member.addMember("Rahul Shetty", "rahul.shetty@mail.com", "9876543211");
//        member.addMember("Priya Nair", "priya.nair@mail.com", "9876543212");
//        member.addMember("Karthik Bhat", "karthik.bhat@mail.com", "9876543213");
//        member.addMember("Sneha Kamath", "sneha.kamath@mail.com", "9876543214");

//        member.modifyMember(1, "Ananya R. Rao", null, null);
//        member.modifyMember(2, null, null, "9000000002");
//        member.modifyMember(3, null, "priya.n@mail.com", null);
//        member.modifyMember(4, "Karthik B", "karthik.b@mail.com", "9000000004");
//        member.modifyMember(99, "Nobody", null, null);
//        member.modifyMember(5, null, "ananya.rao@mail.com", null);
//
//        member.searchMember("a");
//        member.searchMember("kar");

//        borrowing.issueBook(1, 3, 2);
//        borrowing.issueBook(2, 4, 1);
//        borrowing.issueBook(5, 5, 7);

        borrowing.returnBook(2);
    }
}
