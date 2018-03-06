package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class SingleBookTest {

    SingleBook aBook = null;

    @Before
    public void createAFakeBook() {
        aBook = new SingleBook(999,"testName", "testAuthor", 2000);

    }

    @Test
    public void shouldHaveCreatedANewBook() {

        assertEquals(999, aBook.getBookId());
        assertEquals("testName", aBook.getName());
        assertEquals("testAuthor", aBook.getAuthor());
        assertEquals(2000, aBook.getYear());
    }

    @Test
    public void shouldHaveBooksInitialCheckoutState() {

        assertEquals(true, aBook.getIsCheckedOut());
        assertEquals("PersonName", aBook.getCheckedOutByPerson());

    }
}
