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
}
