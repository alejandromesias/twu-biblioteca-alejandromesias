package com.twu.biblioteca;

import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Item;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StorageTest {
    Storage storage;
    ArrayList<UserAccount> fakeUsers;
    ArrayList<Item> fakeMovies;
    ArrayList<Item> fakeBooks;
    ArrayList<CheckOut> fakeCheckOuts;

    @Before
    public void setUp() {
        storage = new Storage();
        fakeUsers = storage.getUsersList();
        fakeMovies = storage.getMoviesList();
        fakeBooks = storage.getBooksList();
        fakeCheckOuts = storage.getCheckOutsList();
    }

    @Test
    public void shouldHaveTheFakeUsers() {
        assertEquals("User0", fakeUsers.get(0).getUserName());
        assertEquals("User1", fakeUsers.get(1).getUserName());
        assertEquals("User2", fakeUsers.get(2).getUserName());
    }

    @Test
    public void shouldHaveTheFakeMovies() {
        assertEquals("theMovie0", fakeMovies.get(0).getName());
        assertEquals("theMovie1", fakeMovies.get(1).getName());
        assertEquals("theMovie2", fakeMovies.get(2).getName());
    }

    @Test
    public void shouldHaveTheFakeBooks() {
        assertEquals("theBook0", fakeBooks.get(0).getName());
        assertEquals("theBook1", fakeBooks.get(1).getName());
        assertEquals("theBook2", fakeBooks.get(2).getName());
    }

    @Test
    public void shouldHaveNoCheckOutsYet() {
        assertEquals(0, fakeCheckOuts.size());
    }
}
