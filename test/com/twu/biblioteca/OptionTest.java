package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class OptionTest {
    private Option option;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        this.option = new Option(1, "List of books");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testOptionRightMessage() {
        assertEquals(option.getMenuMessage(), "List of books");
    }

    @Test
    public void testDisplayOption() {
        String output = "1 List of books\n";
        option.displayOption();
        assertEquals(outContent.toString(), output);
    }

}
