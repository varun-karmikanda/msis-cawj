package com.varunbkarmikanda.lab4.book;

public class TestBook {
    public static void main(String[] args) {
        Author author1 = new Author("Paul Deitel", "paul@deitel.com", 'm');
        Book book1 = new Book("How to program with JAVA", author1, 19.99, 67);
        Book book2 = new Book("JAVA 2 – The Complete Reference", author1, 29.95);

        assert author1.getName().equals("Paul Deitel") : "Author name does not match.";
        assert author1.getEmail().equals("paul@deitel.com") : "Author Email does not match";
        assert author1.getGender() == 'm' : "Gender does not match!";

        assert book1.getName().equals("How to program with JAVA") : "Book name does not match!";
        assert book1.getAuthor().getName().equals("Paul Deitel") : "Book author name does not match!";
        assert book1.getPrice() == 19.99 : "Book price does not match!";
        assert book1.getQty() == 67 : "Book quantity does not match";

        book1.setPrice(24.95);
        assert book1.getPrice() == 24.95 : "Book price does not match!";

        assert book2.getQty() == 0 : "Book quantity does not match";
        book2.setQty(67);
        assert book2.getQty() == 67 : "Book quantity does not match";
    }
}