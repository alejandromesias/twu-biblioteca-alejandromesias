package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class DepotTest {
    Depot depot;
    ArrayList<UserAccount> fakeUsers;
    ArrayList<Movie> fakeMovies;

    @Before
    public void setUp(){
        depot = new Depot();
        fakeUsers = depot.getUsersList();
        fakeMovies = depot.getMoviesList();
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
}