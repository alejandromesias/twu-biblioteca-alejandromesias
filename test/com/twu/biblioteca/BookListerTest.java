package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.ArrayList;

public class BookListerTest {
    BookManager bookManager = new BookManager();
    BibliotecaStorage storage = new BibliotecaStorage();

    @Before
    public void captureStream() {
       storage.initialize();
    }

    @Test
    public void shouldReturnAListOfAllBooks() {
        ArrayList<SingleBook> booksList;
        BookLister bookLister = new BookLister();
        booksList = bookLister.getAllBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook1", booksList.get(1).getName());
        assertEquals("mockBook2", booksList.get(2).getName());
    }

    @Test
    public void shouldReturnAListOfAvailableBooksAfterLending() {
        ArrayList<SingleBook> booksList;
        BookLister bookLister = new BookLister();

        int lendingTestId = 3;
        String lendingTestName = "Test Person";

        bookManager.lend(lendingTestId,lendingTestName);

        booksList = bookLister.getAvailableBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook2", booksList.get(1).getName());

    }

    @Test
    public void shouldReturnAListOfAvailableBooksAfterLendingAndRestoring() {
        ArrayList<SingleBook> booksList;
        BookLister bookLister = new BookLister();

        int lendingTestId = 3;
        String lendingTestName = "Test Person";

        bookManager.lend(lendingTestId,lendingTestName);

        bookManager.restore(lendingTestId,lendingTestName);

        booksList = bookLister.getAvailableBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook1", booksList.get(1).getName());
        assertEquals("mockBook2", booksList.get(2).getName());

    }
}
