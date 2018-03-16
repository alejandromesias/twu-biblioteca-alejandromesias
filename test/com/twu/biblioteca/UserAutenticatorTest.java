package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserAutenticatorTest {


    @Test
    public void shouldRecognizeUserByCredentials() {
        Depot depot = new Depot();
        UserAutenticator autenticator = new UserAutenticator(depot);
        int testBibliotecaId = 2223333;
        String testPassword = "Password1";
        UserAccount expectedUser = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");

        UserAccount activeUser = autenticator.checkCredentials(testBibliotecaId,testPassword);

        assertEquals(expectedUser, activeUser);
    }
}
