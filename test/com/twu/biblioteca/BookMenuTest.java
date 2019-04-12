package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class BookMenuTest {
    private BookMenu bookMenu;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        this.bookMenu = new BookMenu();
        System.setOut(new PrintStream(out));
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
        bookMenu.checkoutBook(bookName);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotCheckoutWithFormatWrong() {
        String bookName = "effective java";
        String output = "Sorry, that book is not available\n";
        bookMenu.checkoutBook(bookName);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotCheckoutWithTwiceCheckout() {
        String bookName = "Effective Java";
        String output = "Thank you! Enjoy the book\n" +
                "Sorry, that book is not available\n";
        bookMenu.checkoutBook(bookName);
        bookMenu.checkoutBook(bookName);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCanReturn() {
        String bookName = "Effective Java";
        bookMenu.checkoutBook(bookName);
        String output = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n";
        bookMenu.returnBook(bookName);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotReturnWithFormatWrong() {
        String bookName = "effective java";
        String output = "That is not a valid book to return\n";
        bookMenu.returnBook(bookName);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testBookCannotReturnWithTwice() {
        String bookName = "Effective Java";
        bookMenu.checkoutBook(bookName);
        String output = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n" +
                "That is not a valid book to return\n";
        bookMenu.returnBook(bookName);
        bookMenu.returnBook(bookName);
        assertEquals(out.toString(), output);
    }


}
