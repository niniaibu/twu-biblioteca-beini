package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class UserTest {
    private User user;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        this.user = new User("123-1234", "123456");
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testUserLibraryNumber() {
        assertEquals(user.getLibraryNumber(), "123-1234");
    }

    @Test
    public void teatUserPasswordValid() {
        assertEquals(user.isValidPassword("123456"), true);
    }

    @Test
    public void teatUserPasswordWrong() {
        assertEquals(user.isValidPassword("654321"), false);
    }

    @Test
    public void testCannotCreateUserWithWrongFormat() {
        String input = "1234-1234";
        String output = "Invalid User for wrong library number\n";
        this.user = new User(input, "123456");
        assertEquals(out.toString(), output);
    }

    @Test
    public void testUserIsLoginFirst() {
        assertEquals(user.isLogin(), false);
    }

    @Test
    public void testUserLogin() {
        String libraryNumber = "123-1234";
        String password = "123456";
        assertEquals(user.login(libraryNumber,password), true);
    }

    @Test
    public void testUserIsNotLoginWithWrongNumber() {
        String libraryNumber = "111-1112";
        String password = "123456";
        assertEquals(user.login(libraryNumber,password), false);
    }

    @Test
    public void testUserIsNotLoginWithWrongPassword() {
        String libraryNumber = "123-1234";
        String password = "111111";
        assertEquals(user.login(libraryNumber,password), false);
    }
}
