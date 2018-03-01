package com.twu.biblioteca;

import org.junit.Test;

import java.awt.print.Book;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldBeABook() {
        Book aBook = new Book("testName", "testAuthor", 2000);

        assertEquals(aBook.getName(), "testName");
        assertEquals(aBook.getAuthor(), "testAuthor");
        assertEquals(aBook.getYear(), 2000);
    }
}
