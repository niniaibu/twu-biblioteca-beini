package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MenuTest {
    private Menu menu;

    @Before
    public void setup() {
        this.menu = new Menu();
    }

    @Test
    public void testMenuMessage() {
        assertEquals(menu.getMenuMessage(),"Main menu:\n" + menu.getOptionId() + " Books");
    }

    @Test
    public void testMenuIdNoValid() {
        assertEquals(menu.isValidInput("0"), false);
    }

    @Test
    public void testMenuIdIsValid() {
        assertEquals(menu.isValidInput("1"), true);
    }
}
