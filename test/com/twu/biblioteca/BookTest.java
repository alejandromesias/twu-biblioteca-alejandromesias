package com.twu.biblioteca;

import com.twu.biblioteca.Types.Book;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookTest {
    private Book aBook;

    @Before
    public void setUp() {
        aBook = new Book(999,"testName",
                "testAuthor", 2000);

    }

    @Test
    public void shouldHaveCreatedANewBook() {

        assertEquals(999, aBook.getItemId());
        assertEquals("testName", aBook.getName());
        assertEquals("testAuthor", aBook.getAuthor());
        assertEquals(2000, aBook.getYear());
    }

}
