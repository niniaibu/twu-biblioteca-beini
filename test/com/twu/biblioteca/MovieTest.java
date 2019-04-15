package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        this.movie = new Movie("Titanic", 1997, "James Cameron", 10);
    }

    @Test
    public void testMovieName() {
        assertEquals(movie.getName(), "Titanic");
    }

    @Test
    public void testMovieYear() {
        assertEquals(movie.getYear(), 1997);
    }

    @Test
    public void testMovieDirector() {
        assertEquals(movie.getDirector(), "James Cameron");
    }

    @Test
    public void testMovieRating() {
        assertEquals(movie.getRating(), 10);
    }
}
