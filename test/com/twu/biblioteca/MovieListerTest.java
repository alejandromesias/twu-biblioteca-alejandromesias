package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieListerTest {
    @Test
    public void shouldReturnATableOfMovies() {
        Depot depot = new Depot();
        MovieLister movieLister = new MovieLister(depot);

        String moviesList = movieLister.getMoviesList();

        String header = "ID   Movie Name     Director       Year Rating    \n";
        String row0   = "3    theMovie0      Director0      2010 10        \n";
        String row1   = "4    theMovie1      Director1      2011 9         \n";
        String row2   = "5    theMovie2      Director2      2012 0         \n";
        String expectedList = header + row0 + row1 + row2;

        assertEquals(expectedList,moviesList);
    }
}
