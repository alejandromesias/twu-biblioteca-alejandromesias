package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BookManagerTest {
    @Before
    public void refreshStorage() {
        BibliotecaStorage.initialize();
    }

    @Test
    public void shouldLendABookById() {
        int requestedBookId = 3;
        String personName = "Jane Doe";

        Boolean wasLent = BookManager.lend(requestedBookId,personName);
        assertTrue(wasLent);
    }

    @Test
    public void shouldUpdateABibliotecaStorageWhenLending() {

        int testId = 3;
        String TestName = "Test Person";

        BookManager.lend(testId, TestName);

        ArrayList<SingleBook> newFakeBooks = BibliotecaStorage.getBookCollection();

        SingleBook TestBook= newFakeBooks.get(1);

        assertTrue(TestBook.getIsCheckedOut());
        assertEquals(TestName, TestBook.getCheckedOutByPerson());
    }

    @Test
    public void shouldLendThenRestoreABookByIdAndName() {
        int requestedBookId = 3;
        String personName = "Jane Doe";

        Boolean wasLent = BookManager.lend(requestedBookId,personName);
        assertTrue(wasLent);

        Boolean wasRestored = BookManager.restore(requestedBookId,personName);
        assertTrue(wasRestored);
    }
}
