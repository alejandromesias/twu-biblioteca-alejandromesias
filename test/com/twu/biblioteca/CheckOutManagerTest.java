package com.twu.biblioteca;

import com.twu.biblioteca.Controllers.CheckOutManager;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Types.Book;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CheckOutManagerTest {

    @Test
    public void shouldRegisterACheckOutToKnownUserForMovies() throws WrongItemIdException, Exception {
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
        CheckOutManager manager = new CheckOutManager(storage, "movie");

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
        int fakeMovieId = 2;
        CheckOutManager manager = new CheckOutManager(storage, "movie");

        manager.performCheckOut(testUser, fakeMovieId);
    }

    @Test
    public void shouldRegisterACheckOutToKnownUserForBooks() throws WrongItemIdException, Exception {
        Storage storage = new Storage();
        UserAccount testUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");

        Book testBook = new Book(2,
                "theBook0",
                "Author0",
                2000);
        CheckOut expectedCheckout = new CheckOut(testUser, testBook);
        CheckOutManager manager = new CheckOutManager(storage, "book");

        manager.performCheckOut(testUser, testBook.getItemId());

        CheckOut newCheckout = storage.getCheckOutsList().get(0);

        assertEquals(expectedCheckout.getUserAccount(), newCheckout.getUserAccount());
        assertEquals(expectedCheckout.getLentMovie(), newCheckout.getLentMovie());
    }

    @Test(expected = WrongItemIdException.class)
    public void shouldThrowAnExceptionWhenInexistentBookId() throws WrongItemIdException, Exception {
        Storage storage = new Storage();
        UserAccount testUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        int fakeBookId = 5;
        CheckOutManager manager = new CheckOutManager(storage, "book");

        manager.performCheckOut(testUser, fakeBookId);
    }
}