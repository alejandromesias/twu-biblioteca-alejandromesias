package com.twu.biblioteca;

import org.junit.Test;

import java.net.Authenticator;

import static junit.framework.TestCase.assertEquals;

public class CheckOutManagerTest {


    @Test
    public void shouldRegisterACheckOutToAuthenticatedUser() {
        Depot depot = new Depot();
        UserAccount testUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");

        Movie testMovie = new Movie(3,
                "theMovie0",
                "Director0",
                2010,
                10);
        CheckOut expectedCheckout = new CheckOut(testUser, testMovie);
        Authenticator authenticator;


        CheckOutManager manager ;

        //manager.performCheckOut(testUser,testMovie);

        CheckOut newCheckout = depot.getCheckOutsList().get(0);

        assertEquals(expectedCheckout,newCheckout);
    }
}
