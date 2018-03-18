package com.twu.biblioteca;

import com.twu.biblioteca.Types.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Movie aMovie;

    @Before
    public void setUp(){
        aMovie = new Movie(888, "testName",
                "testDirector", 2000,
                10);
    }

    @Test
    public void shouldHaveCreatedAMovie() {
        aMovie = new Movie(888, "testName",
                "testDirector", 2000,
                10);

        assertEquals(888, aMovie.getMovieId());
        assertEquals("testName", aMovie.getName());
        assertEquals("testDirector", aMovie.getDirector());
        assertEquals(2000, aMovie.getYear());
        assertEquals(10, aMovie.getRating());
    }

    @Test
    public void shouldHaveCreatedAMovieWithOutRating() {
        aMovie = new Movie(888, "testName",
                "testDirector", 2000);

        assertEquals(888, aMovie.getMovieId());
        assertEquals("testName", aMovie.getName());
        assertEquals("testDirector", aMovie.getDirector());
        assertEquals(2000, aMovie.getYear());
        assertEquals(0, aMovie.getRating());
    }
}
