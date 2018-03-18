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
        Depot depot = new Depot();
        UserAccount aUser = depot.getUsersList().get(0);
        Movie aMovie = depot.getMoviesList().get(0);
        CheckOut firstCheckOut = new CheckOut(aUser, aMovie);
        depot.addCheckout(firstCheckOut);

        assertEquals(1,depot.getCheckOutsList().size());

        RestoreManager restoreManager = new RestoreManager(depot);
        restoreManager.performRestore(aUser,aMovie);

        assertEquals(0,depot.getCheckOutsList().size());
    }

}
