package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BibliotecaStorageTest {

    @Test
    public void shouldHaveSomeBooks() {
        BibliotecaStorage.initialize();

        ArrayList<SingleBook> fakeBooks = new ArrayList<SingleBook>();

        fakeBooks = BibliotecaStorage.getBookCollection();

        assertEquals("mockBook0a", fakeBooks.get(0).getName());
        assertEquals("mockBook1a", fakeBooks.get(1).getName());
        assertEquals("mockBook2a", fakeBooks.get(2).getName());
    }
}
