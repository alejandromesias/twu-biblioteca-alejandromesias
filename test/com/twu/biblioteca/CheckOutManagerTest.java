package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CheckOutManagerTest {


    @Test
    public void shouldRegisterACheckOutToKnownUser() {
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
        CheckOutManager manager = new CheckOutManager(depot);

        try {
            manager.performCheckOut(testUser, testMovie.getMovieId());
        }catch(Exception exception){

        }

        CheckOut newCheckout = depot.getCheckOutsList().get(0);

        assertEquals(expectedCheckout.getUserAccount(),newCheckout.getUserAccount());
        assertEquals(expectedCheckout.getLentMovie(),newCheckout.getLentMovie());
    }

    @Test
    public void shouldThrowAnExceptionWhenInexistentMovieId() {
        Depot depot = new Depot();
        UserAccount testUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        int fakeMovieId = 100;
        CheckOutManager manager = new CheckOutManager(depot);

        String message = "";
        try {
            manager.performCheckOut(testUser, fakeMovieId);
        }catch(Exception exception){
            message = exception.getMessage();
        }

        assertEquals("That movie is not available",message);

    }
}
