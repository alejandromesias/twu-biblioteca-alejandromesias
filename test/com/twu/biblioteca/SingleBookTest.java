package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SingleBookTest {

    @Test
    public void shouldHaveCreatedANewBook() {
        SingleBook aBook = new SingleBook(999,"testName", "testAuthor", 2000);

        assertEquals(999, aBook.getBookId());
        assertEquals("testName", aBook.getName());
        assertEquals("testAuthor", aBook.getAuthor());
        assertEquals(2000, aBook.getYear());
    }
}
