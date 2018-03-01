package com.twu.biblioteca;

import org.junit.Test;

public class MessagesTest {
    @Test
    public void shouldReturnWelcome() {
        String welcomeMessage = Messages.welcome();

        assertEquals(welcomeMessage,"Welcome to Biblioteca!- Enjoy Books");
    }
}
