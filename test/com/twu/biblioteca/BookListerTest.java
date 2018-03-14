package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.ArrayList;

public class BookListerTest {

    @Before
    public void captureStream() {
        BibliotecaStorage.initialize();
    }

    @Test
    public void ShouldReturnAListOfAllBooks() {
        ArrayList<SingleBook> booksList;
        BookLister bookLister = new BookLister();
        booksList = bookLister.getAllBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook1", booksList.get(1).getName());
        assertEquals("mockBook2", booksList.get(2).getName());
    }

    @Test
    public void ShouldReturnAListOfAvailableBooksAfterLending() {
        ArrayList<SingleBook> booksList;
        BookLister bookLister = new BookLister();

        int lendingTestId = 3;
        String lendingTestName = "Test Person";

        BookManager.lend(lendingTestId,lendingTestName);

        booksList = bookLister.getAvailableBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook2", booksList.get(1).getName());

    }

    @Test
    public void ShouldReturnAListOfAvailableBooksAfterLendingAndRestoring() {
        ArrayList<SingleBook> booksList;
        BookLister bookLister = new BookLister();

        int lendingTestId = 3;
        String lendingTestName = "Test Person";

        BookManager.lend(lendingTestId,lendingTestName);

        BookManager.restore(lendingTestId,lendingTestName);

        booksList = bookLister.getAvailableBooks();

        assertEquals("mockBook0", booksList.get(0).getName());
        assertEquals("mockBook1", booksList.get(1).getName());
        assertEquals("mockBook2", booksList.get(2).getName());

    }
}
