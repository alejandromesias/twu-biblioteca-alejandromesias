package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class DepotTest {
    Depot depot;
    ArrayList<UserAccount> fakeUsers;

    @Before
    public void setUp(){
        depot = new Depot();
        fakeUsers = depot.getUsersList();
    }

    @Test
    public void shouldHaveTheFakeUsers() {
        assertEquals("User0", fakeUsers.get(0).getUserName());
        assertEquals("User1", fakeUsers.get(1).getUserName());
        assertEquals("User2", fakeUsers.get(2).getUserName());
    }
}
