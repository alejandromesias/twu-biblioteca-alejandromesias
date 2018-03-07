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

        assertEquals("mockBook0", fakeBooks.get(0).getName());
        assertEquals("mockBook1", fakeBooks.get(1).getName());
        assertEquals("mockBook2", fakeBooks.get(2).getName());
    }
}
