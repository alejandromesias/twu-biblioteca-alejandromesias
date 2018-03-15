package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BookManagerTest {
    BibliotecaStorage storage = new BibliotecaStorage();
    BookManager bookManager = new BookManager();

    @Before
    public void refreshStorage() {
        storage.initialize();
    }

    @Test
    public void shouldLendABookById() {
        int requestedBookId = 3;
        String personName = "Jane Doe";

        Boolean wasLent = bookManager.lend(requestedBookId,personName);
        assertTrue(wasLent);
    }

    @Test
    public void shouldUpdateABibliotecaStorageWhenLending() {

        int testId = 3;
        String TestName = "Test Person";

        bookManager.lend(testId, TestName);

        ArrayList<Book> newFakeBooks = storage.getBookCollection();

        Book TestBook= newFakeBooks.get(1);

        assertTrue(TestBook.getIsCheckedOut());
        assertEquals(TestName, TestBook.getCheckedOutByPerson());
    }

    @Test
    public void shouldLendThenRestoreABookByIdAndName() {
        int requestedBookId = 3;
        String personName = "Jane Doe";

        Boolean wasLent = bookManager.lend(requestedBookId,personName);
        assertTrue(wasLent);

        Boolean wasRestored = bookManager.restore(requestedBookId,personName);
        assertTrue(wasRestored);
    }

    @Test
    public void shouldnotRestoreAnInexistingBook() {
        int requestedBookId = 8;
        String personName = "Jane Doe";

        Boolean wasRestored = bookManager.restore(requestedBookId,personName);
        assertFalse(wasRestored);
    }

    @Test
    public void shouldnotRestoreAnAvailableBook() {
        int requestedBookId = 3;
        String personName = "Jane Doe";

        Boolean wasRestored = bookManager.restore(requestedBookId,personName);
        assertFalse(wasRestored);
    }
}
