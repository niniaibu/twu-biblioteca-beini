package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookMenu {
    private List<Book> books;

    public BookMenu() {
        this.books = new ArrayList<>();
        addBook();
    }

    public List<Book> addBook() {
        books.add(new Book("Head First Java", "Kathy Sierra", 2003));
        books.add(new Book("Effective Java", "Joshua Bloch", 2001));
        books.add(new Book("Thinking in Java", "Bruce Eckel", 1998));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", 2004));
        return books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        books.forEach(book -> System.out.println(book.getDisplayMessage()));
    }

    public void checkoutBook(String bookName, User userLogin) {
        for (Book book : books) {
            if (bookName.equals(book.getName()) && !book.isCheckout()) {
                book.setCheckout(true);
                book.setUser(userLogin);
                book.setReturn(false);
                System.out.println("Thank you! Enjoy the book");
                return;
            }
        }
        System.out.println("Sorry, that book is not available");
    }

    public void returnBook(String bookName, User userLogin) {
        for (Book book : books) {
            if (bookName.equals(book.getName()) && book.isCheckout() && !book.isReturn()) {
                book.setCheckout(false);
                book.setReturn(true);
                System.out.println("Thank you for returning the book");
                return;
            }
        }
        System.out.println("That is not a valid book to return");
    }

    public void viewCheckoutedBooks() {
        System.out.println("Book cheched out: ");
        for (Book book : books) {
            if (book.isCheckout()) {
                System.out.println(book.getName()+ "|"+ book.getUser().getLibraryNumber());
            }
        }
    }
}
