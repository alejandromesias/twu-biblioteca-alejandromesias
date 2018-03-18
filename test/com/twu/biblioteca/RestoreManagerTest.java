package com.twu.biblioteca;

import com.twu.biblioteca.Controllers.CheckOutManager;
import com.twu.biblioteca.Controllers.RestoreManager;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RestoreManagerTest {

    @Test
    public void shouldRestoreAnItemFromKnownUser() throws WrongItemIdException {
        Storage storage = new Storage();
        UserAccount aUser = storage.getUsersList().get(1);
        Movie aMovie = storage.getMoviesList().get(1);
        int movieId = aMovie.getMovieId();
        CheckOut firstCheckOut = new CheckOut(aUser, aMovie);
        storage.addCheckout(firstCheckOut);

        assertEquals(1,storage.getCheckOutsList().size());

        RestoreManager restoreManager = new RestoreManager(storage);
        restoreManager.performRestore(aUser,movieId);

        assertEquals(0,storage.getCheckOutsList().size());
    }

    @Test(expected = WrongItemIdException.class)
    public void shouldThrowAnExceptionWhenInexistentMovieId() throws WrongItemIdException {
        Storage storage = new Storage();
        UserAccount testUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        int fakeMovieId = 100;
        RestoreManager manager = new RestoreManager(storage);

        manager.performRestore(testUser, fakeMovieId);
    }

}
