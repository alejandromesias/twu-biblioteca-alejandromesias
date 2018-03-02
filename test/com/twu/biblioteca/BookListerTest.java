package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class BookListerTest {
    @Test
    public void ShouldReturnAListOfAllBooks() {
        ArrayList<SingleBook> booksList;

        booksList = BookLister.getAllBooks();

        assertEquals("mockLibro0", booksList.get(0).getName());
        assertEquals("mockLibro1", booksList.get(1).getName());
        assertEquals("mockLibro2", booksList.get(2).getName());
    }
}
