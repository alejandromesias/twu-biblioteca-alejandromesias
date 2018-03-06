package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class BookManagerTest {
    @Test
    public void shouldLendABookById() {
        int bookId = 3;
        String personName = "Jane Doe";

        Boolean wasLend = BookManager.lend(bookId,personName);
        assertTrue(wasLend);
    }
}
