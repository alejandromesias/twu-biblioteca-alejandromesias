package com.twu.biblioteca;

import com.twu.biblioteca.Controllers.CheckOutManager;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CheckOutManagerTest {

    @Test
    public void shouldRegisterACheckOutToKnownUser() throws WrongItemIdException, Exception {
        Storage storage = new Storage();
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
        CheckOutManager manager = new CheckOutManager(storage);

        manager.performCheckOut(testUser, testMovie.getItemId());

        CheckOut newCheckout = storage.getCheckOutsList().get(0);

        assertEquals(expectedCheckout.getUserAccount(), newCheckout.getUserAccount());
        assertEquals(expectedCheckout.getLentMovie(), newCheckout.getLentMovie());
    }

    @Test(expected = WrongItemIdException.class)
    public void shouldThrowAnExceptionWhenInexistentMovieId() throws WrongItemIdException, Exception {
        Storage storage = new Storage();
        UserAccount testUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        int fakeMovieId = 100;
        CheckOutManager manager = new CheckOutManager(storage);

        manager.performCheckOut(testUser, fakeMovieId);
    }
}
