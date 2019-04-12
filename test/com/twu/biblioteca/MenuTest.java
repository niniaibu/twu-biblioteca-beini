package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class MenuTest {
    private Menu menu;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayInputStream in;

    @Before
    public void setUp() {
        this.menu = new Menu();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testEmptyMenuQuit() {
        assertEquals(menu.isQuit(), false);
    }

    @Test
    public void testEmptyMenuOption() {
        String output = "Main menu:\n" +
                "-1 quit\n" +
                "1 List of books\n" +
                "2 Checkout out a book\n";
        menu.displayMenu();
        assertEquals(out.toString(), output);
    }

    @Test
    public void testMenuIdNoValid() {
        assertEquals(menu.isValidInput("0"), false);
    }

    @Test
    public void testNoValidOutput() {
        String output = "Please select a valid option!\n";
        menu.isValidInput("0");
        assertEquals(out.toString(), output);
    }

    @Test
    public void testMenuIdIsValid() {
        assertEquals(menu.isValidInput("1"), true);
    }

    // @Test
    // public void testJudgeUserMenuInput() throws IOException {
    //     String output = "Please input checkout book name: ";
    //     String arg = "2";
    //     menu.judgeUserMenuInput(arg);
    //     assertEquals(out.toString(), output);
    // }

    @Test
    public void testIsQuitAtBegin() {
        assertEquals(menu.isQuit(), false);
    }

    @Test
    public void testIsQuitChange() throws IOException {
        String arg = "-1";
        menu.judgeUserMenuInput(arg);
        assertEquals(menu.isQuit(), true);
    }
}
