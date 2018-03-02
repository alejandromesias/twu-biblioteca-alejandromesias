package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class BookListerTest {
    @Test
    public void ShouldReturnAListOfAllBooks() {
        ArrayList<SingleBook> booksList;

        booksList = BookLister.getAllBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook1", booksList.get(1).getName());
        assertEquals("mockBook2", booksList.get(2).getName());
    }
}
