package com.twu.biblioteca;

import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CheckOutTest {

    @Test
    public void shouldHaveCreatedACheckOut(){
       UserAccount oneUserAccount = new UserAccount(1231234,
                    "TestPassword!",
                    "testName",
                    "testName@email.com",
                    "0986424406");

       Movie aMovie = new Movie(888, "testName",
                "testDirector", 2000,
                10);

       CheckOut aCheckOut = new CheckOut(oneUserAccount, aMovie);

        assertEquals(oneUserAccount, aCheckOut.getUserAccount());
        assertEquals(aMovie, aCheckOut.getLentMovie());
        assertTrue(aCheckOut.isCheckOutActive());
    }
}
