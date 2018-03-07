package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BookManagerTest {
    @Test
    public void shouldLendABookById() {
        int requestedBookId = 3;
        String personName = "Jane Doe";

        Boolean wasLend = BookManager.lend(requestedBookId,personName);
        assertTrue(wasLend);
    }

    @Test
    public void shouldUpdateABibliotecaStorageWhenLending() {
        BibliotecaStorage.initialize();

        ArrayList<SingleBook> fakeBooks = BibliotecaStorage.getBookCollection();

        assertFalse(fakeBooks.get(1).getIsCheckedOut());

        int testId = 3;
        String TestName = "Test Person";

        BookManager.lend(testId, TestName);

        ArrayList<SingleBook> newFakeBooks = BibliotecaStorage.getBookCollection();

        assertTrue(newFakeBooks.get(1).getIsCheckedOut());
        assertEquals(TestName, newFakeBooks.get(1).getCheckedOutByPerson());
    }
}
