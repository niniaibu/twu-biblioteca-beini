package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class MovieMenuTest {
    private MovieMenu movieMenu;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        this.movieMenu = new MovieMenu();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testMovieMenuLength() {
        assertEquals(movieMenu.getMovies().size(), 4);
    }

    @Test
    public void testDisplayMovieMenu() {
        String output = "Titanic|1997|James Cameron|10\n" +
                "The Fast and the Furious|2001|Rob Cohen|7\n" +
                "Avatar|2009|James Cameron|9\n" +
                "The Wandering Earth|2019|Frant Gwo|5\n";
        movieMenu.displayMovieMenu();
        assertEquals(out.toString(), output);
    }


}
