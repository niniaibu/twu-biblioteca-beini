package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("java", "nini", 2000);
    }

    @Test
    public void testBookName() {
        assertEquals(book.getName(), "java");
    }

    @Test
    public void testBookAuthor() {
        assertEquals(book.getAuthor(), "nini");
    }

    @Test
    public void testBookpublication() {
        assertEquals(book.getPublication(), 2000);
    }

    @Test
    public void testDisplayMessage() {
        assertEquals(book.getDisplayMessage(),"java|nini|2000");
    }

    @Test
    public void testCheckoutBook() {
        assertEquals(book.isCheckout(),false);
    }

    @Test
    public void testReturnBook() {
        assertEquals(book.isReturn(),true);
    }
}
