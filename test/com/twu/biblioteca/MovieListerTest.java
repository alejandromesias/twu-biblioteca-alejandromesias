package com.twu.biblioteca;

import com.twu.biblioteca.Controllers.MovieLister;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MovieListerTest {
    @Test
    public void shouldReturnATextOfMovies() {
        Storage storage = new Storage();
        MovieLister movieLister = new MovieLister(storage);

        String moviesList = movieLister.getMoviesList();

        String header = "ID   Movie Name     Director       Year Rating    \n";
        String row0 = "3    theMovie0      Director0      2010 10        \n";
        String row1 = "4    theMovie1      Director1      2011 9         \n";
        String row2 = "5    theMovie2      Director2      2012 unrated   \n";
        String expectedList = header + row0 + row1 + row2;

        assertEquals(expectedList, moviesList);
    }

    @Test
    public void shouldReturnAnArrayOfOnlyAvailableMovies() {
        Storage storage = new Storage();
        UserAccount aUser = storage.getUsersList().get(0);
        Movie firstMovie = storage.getMoviesList().get(0);
        Movie secondMovie = storage.getMoviesList().get(1);
        CheckOut firstCheckOut = new CheckOut(aUser, firstMovie);
        CheckOut secondCheckOut = new CheckOut(aUser, secondMovie);
        storage.addCheckout(firstCheckOut);
        storage.addCheckout(secondCheckOut);

        MovieLister movieLister = new MovieLister(storage);
        ArrayList<Movie> availableMovies = movieLister.getAvailableMoviesList();

        assertEquals(storage.getMoviesList().get(2), availableMovies.get(0));
    }
}
