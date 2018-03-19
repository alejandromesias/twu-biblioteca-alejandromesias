package com.twu.biblioteca;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.twu.biblioteca.Controllers.ItemLister;
import com.twu.biblioteca.Controllers.MovieLister;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ItemListerTest {
    @Test
    public void shouldReturnATextOfMovies() {
        Storage storage = new Storage();
        ItemLister itemLister = new ItemLister(storage, "movie");

        String moviesList = itemLister.getPrintableList();

        String header = "ID   Movie Name     Director       Year Rating    \n";
        String row0   = "3    theMovie0      Director0      2010 10        \n";
        String row1   = "4    theMovie1      Director1      2011 9         \n";
        String row2   = "5    theMovie2      Director2      2012 unrated   \n";
        String expectedList = header + row0 + row1 + row2;

        assertEquals(expectedList, moviesList);
    }

    @Test
    public void shouldReturnATextOfBooks() {
        Storage storage = new Storage();
        ItemLister itemLister = new ItemLister(storage,"book");

        String booksList = itemLister.getPrintableList();

        String header = "ID   Book Name      Author         Year \n";
        String row0   = "2    theBook0       Author0        2000 \n";
        String row1   = "3    theBook1       Author1        2001 \n";
        String row2   = "4    theBook2       Author2        2002 \n";
        String expectedList = header + row0 + row1 + row2;


        assertEquals(expectedList, booksList);
    }

    @Test
    public void shouldReturnAnArrayOfOnlyAvailableMovies() throws Exception{
        Storage storage = new Storage();
        UserAccount aUser = storage.getUsersList().get(0);
        Movie firstMovie = (Movie) storage.getMoviesList().get(0);
        Movie secondMovie = (Movie) storage.getMoviesList().get(1);
        CheckOut firstCheckOut = new CheckOut(aUser, firstMovie);
        CheckOut secondCheckOut = new CheckOut(aUser, secondMovie);
        storage.addCheckout(firstCheckOut);
        storage.addCheckout(secondCheckOut);

        ItemLister movieLister = new ItemLister(storage, "movie");
        ArrayList<Movie> availableMovies = (ArrayList<Movie>)(Object) movieLister.getAvailableItemsListOfType();

        assertEquals(storage.getMoviesList().get(2), availableMovies.get(0));
    }
}
