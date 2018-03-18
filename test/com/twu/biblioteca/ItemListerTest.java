package com.twu.biblioteca;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.twu.biblioteca.Controllers.ItemLister;
import com.twu.biblioteca.Controllers.MovieLister;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ItemListerTest {
    @Test
    public void shouldReturnATextOfMovies() {
        Storage storage = new Storage();
        ItemLister itemLister = new ItemLister(storage);

        String moviesList = itemLister.getPrintableList("movie");

        String header = "ID   Movie Name     Director       Year Rating    \n";
        String row0 = "3    theMovie0      Director0      2010 10        \n";
        String row1 = "4    theMovie1      Director1      2011 9         \n";
        String row2 = "5    theMovie2      Director2      2012 unrated   \n";
        String expectedList = header + row0 + row1 + row2;

        assertEquals(expectedList, moviesList);
    }

    @Test
    public void shouldReturnATextOfBooks() {
        Storage storage = new Storage();
        ItemLister itemLister = new ItemLister(storage);

        String booksList = itemLister.getPrintableList("book");

        String header = "ID   Book Name      Author         Year \n";
        String row0   = "2    mockBook0      author0        2000 \n";
        String row1   = "3    mockBook1      author1        2001 \n";
        String row2   = "4    mockBook2      author2        2002 \n";
        String expectedList = header + row0 + row1 + row2;


        assertEquals(expectedList, booksList);
    }
}
