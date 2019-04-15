package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class BookMenuTest {
    private BookMenu bookMenu;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private User user;

    @Before
    public void setUp() {
        this.bookMenu = new BookMenu();
        System.setOut(new PrintStream(out));
        this.user = new User("111-1111", "111111");
    }

    @Test
    public void testBookMenulenght() {
        assertEquals(bookMenu.getBooks().size(), 4);
    }

    @Test
    public void testBookMenuDisplay() {
        String outputString = "Head First Java|Kathy Sierra|2003\n" +
                "Effective Java|Joshua Bloch|2001\n" +
                "Thinking in Java|Bruce Eckel|1998\n" +
                "Head First Design Patterns|Eric Freeman|2004\n";
        bookMenu.displayBooks();
        assertEquals(out.toString(), outputString);
    }

    @Test
    public void testBookCanCheckout() {
        String bookName = "Effective Java";
        String output = "Thank you! Enjoy the book\n";
        bookMenu.checkoutBook(bookName, user);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotCheckoutWithFormatWrong() {
        String bookName = "effective java";
        String output = "Sorry, that book is not available\n";
        bookMenu.checkoutBook(bookName, user);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotCheckoutWithTwiceCheckout() {
        String bookName = "Effective Java";
        String output = "Thank you! Enjoy the book\n" +
                "Sorry, that book is not available\n";
        bookMenu.checkoutBook(bookName, user);
        bookMenu.checkoutBook(bookName, user);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCanReturn() {
        String bookName = "Effective Java";
        bookMenu.checkoutBook(bookName, user);
        String output = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n";
        bookMenu.returnBook(bookName, user);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotReturnWithFormatWrong() {
        String bookName = "effective java";
        String output = "That is not a valid book to return\n";
        bookMenu.returnBook(bookName, user);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotReturnWithTwice() {
        String bookName = "Effective Java";
        bookMenu.checkoutBook(bookName, user);
        String output = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n" +
                "That is not a valid book to return\n";
        bookMenu.returnBook(bookName, user);
        bookMenu.returnBook(bookName, user);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCheckedoutEmpty() {
        bookMenu.viewCheckoutedBooks();
        String output = "Book cheched out: \n";
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCheckedoutOneBookCheckout() {
        String bookName = "Effective Java";
        bookMenu.checkoutBook(bookName, user);
        bookMenu.viewCheckoutedBooks();
        String output = "Thank you! Enjoy the book\n" +
                "Book cheched out: \n" +
                "Effective Java|111-1111\n";
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCheckedoutMultipleBookCheckout() {
        bookMenu.checkoutBook("Effective Java", user);
        bookMenu.checkoutBook("Head First Java", user);
        bookMenu.viewCheckoutedBooks();
        String output = "Thank you! Enjoy the book\n" +
                "Thank you! Enjoy the book\n" +
                "Book cheched out: \n" +
                "Head First Java|111-1111\n" +
                "Effective Java|111-1111\n";
        assertEquals(out.toString(), output);
    }

}
