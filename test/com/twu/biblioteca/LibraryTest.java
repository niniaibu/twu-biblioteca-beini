package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;


public class LibraryTest {
    private Library library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        this.library = new Library();
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testWelcomeMessage() {
        String outputString = "Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!\n\n";
        library.displayWelcomeMessage();
        assertEquals(outContent.toString(), outputString);
    }
}
