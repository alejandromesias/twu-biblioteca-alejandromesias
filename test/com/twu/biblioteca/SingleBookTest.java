package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SingleBookTest {

    @Test
    public void shouldBeABook() {
        SingleBook aBook = new SingleBook("testName", "testAuthor", 2000);

        assertEquals("testName", aBook.getName());
        assertEquals("testAuthor", aBook.getAuthor());
        assertEquals(2000, aBook.getYear());
    }
}
