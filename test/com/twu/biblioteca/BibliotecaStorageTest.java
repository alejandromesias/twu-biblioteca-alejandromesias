package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BibliotecaStorageTest {

    ArrayList<SingleBook> fakeBooks;

    @Before
    public void setUp(){
        BibliotecaStorage.initialize();

        fakeBooks = BibliotecaStorage.getBookCollection();
    }


    @Test
    public void shouldHaveSomeBooks() {

        assertEquals("mockBook0", fakeBooks.get(0).getName());
        assertEquals("mockBook1", fakeBooks.get(1).getName());
        assertEquals("mockBook2", fakeBooks.get(2).getName());
    }

    @Test
    public void shouldUpdateABook() {
        assertEquals(2001, fakeBooks.get(1).getYear());

        ArrayList<SingleBook> newFakeBooks = BibliotecaStorage.getBookCollection();

        SingleBook alteredBook = new SingleBook(3,"mockBook1", "author1", 2011);

        BibliotecaStorage.updateBook(alteredBook);

        assertEquals(2011, newFakeBooks.get(1).getYear());
    }



}
