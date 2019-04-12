package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class BookMenuTest {
    private BookMenu bookMenu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        this.bookMenu = new BookMenu();
        System.setOut(new PrintStream(outContent));
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
        assertEquals(outContent.toString(), outputString);
    }


}
