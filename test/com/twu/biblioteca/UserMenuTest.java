package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class UserMenuTest {
    private UserMenu userMenu;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        this.userMenu = new UserMenu();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testUserMenuLength() {
        assertEquals(userMenu.getUsers().size(), 4);
    }

    @Test
    public void testUserLogin() {
        String userLibraryNumber = "111-1111";
        String userPassword = "111111";
        String output = "Hi, 111-1111 !\n";
        userMenu.userLogin(userLibraryNumber, userPassword);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testUserWithFormatWrongPassword() {
        String userLibraryNumber = "111-1111";
        String userPassword = "123456";
        String output = "Wrong, please input again\n";
        userMenu.userLogin(userLibraryNumber, userPassword);
        assertEquals(out.toString(), output);
    }

    @Test
    public void testUserWithFormatWrongLibraryNumber() {
        String userLibraryNumber = "111-1234";
        String userPassword = "111111";
        String output = "Wrong, please input again\n";
        userMenu.userLogin(userLibraryNumber, userPassword);
        assertEquals(out.toString(), output);
    }
}
