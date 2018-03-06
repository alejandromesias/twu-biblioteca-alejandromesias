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

        assertEquals(false, aBook.getIsCheckedOut());
        assertEquals(null, aBook.getCheckedOutByPerson());
    }

    @Test
    public void shouldChangeBooksCheckoutState() {

        aBook.setIsCheckedOut(true);
        aBook.setCheckedOutByPerson("Jane Doe");

        assertEquals(true, aBook.getIsCheckedOut());
        assertEquals("Jane Doe", aBook.getCheckedOutByPerson());
    }

    @Test
    public void shouldChangeBooksCheckoutStateBack() {

        aBook.setIsCheckedOut(false);
        aBook.setCheckedOutByPerson(null);

        assertEquals(false, aBook.getIsCheckedOut());
        assertEquals(null, aBook.getCheckedOutByPerson());
    }
}
