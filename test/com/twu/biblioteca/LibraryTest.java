package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class LibraryTest {
    private Library library;

    @Before
    public void setup() {
        this.library = new Library();
    }

    @Test
    public void testWelcomeMessage() {
        assertEquals(library.getWelcomeMessage(),"Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!");
    }
}
