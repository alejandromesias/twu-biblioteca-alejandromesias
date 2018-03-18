package com.twu.biblioteca;

import com.twu.biblioteca.Controllers.UserAuthenticator;
import com.twu.biblioteca.Exceptions.WrongIdException;
import com.twu.biblioteca.Exceptions.WrongPasswordException;
import com.twu.biblioteca.Types.UserAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotEquals;

public class UserAuthenticatorTest {

    @Test
    public void shouldRecognizeUserByCredentials() throws WrongIdException, WrongPasswordException {
        Depot depot = new Depot();
        UserAccount expectedUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");

        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password1";

        UserAccount activeUser = authenticator.checkUserCredentials(testBibliotecaId, testPassword);
        assertEquals(expectedUser, activeUser);

    }

    @Test
    public void shouldTellTheActiveLoggedUser() throws WrongPasswordException, WrongIdException{
        Depot depot = new Depot();
        UserAccount expectedUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password1";

        authenticator.checkUserCredentials(testBibliotecaId,testPassword);
        UserAccount activeUser = authenticator.getCurrentActiveUser();
        assertEquals(expectedUser, activeUser);

    }

    @Test(expected = WrongIdException.class)
    public void shouldRejectUserCauseWrongId() throws WrongIdException, WrongPasswordException {
        Depot depot = new Depot();
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 0112222;
        String testPassword = "Password1";

        authenticator.checkUserCredentials(testBibliotecaId, testPassword);
    }

    @Test(expected = WrongPasswordException.class)
    public void shouldRejectUserCauseWrongPassword() throws WrongIdException, WrongPasswordException {
        Depot depot = new Depot();
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password8";
        String message1 = "";
        String message2 = "";

        authenticator.checkUserCredentials(testBibliotecaId, testPassword);
    }


}
