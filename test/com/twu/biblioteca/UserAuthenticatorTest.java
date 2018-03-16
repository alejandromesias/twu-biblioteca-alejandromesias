package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotEquals;

public class UserAuthenticatorTest {

    Depot depot = new Depot();
    UserAccount expectedUser = new UserAccount(2223333,
            "Password1",
            "User1",
            "user1@email.com",
            "0888888888");

    @Test
    public void shouldRecognizeUserByCredentials() {
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password1";

        UserAccount activeUser = authenticator.checkUserCredentials(testBibliotecaId,testPassword);

        assertEquals(expectedUser, activeUser);
    }

    @Test
    public void shouldRejectUserCauseWrongId() {
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 1112222;
        String testPassword = "Password1";

        UserAccount activeUser = authenticator.checkUserCredentials(testBibliotecaId,testPassword);

        assertNull(activeUser);
    }

    @Test
    public void shouldRejectUserCauseWrongPassword() {
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password2";

        UserAccount activeUser = authenticator.checkUserCredentials(testBibliotecaId,testPassword);

        assertNull(activeUser);
    }

    @Test
    public void shouldTellTheActiveLoggedUser() {
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password1";
        authenticator.checkUserCredentials(testBibliotecaId,testPassword);

        UserAccount activeUser = authenticator.getCurrentActiveUser();

        assertEquals(expectedUser, activeUser);
    }
}
