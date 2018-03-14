package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessagesBiblioTest {
    MessagesBiblio messages = new MessagesBiblio();

    @Test
    public void shouldReturnTheWelcomeMessage() {
        String welcomeMessage = messages.welcome();

        assertEquals("Welcome to Biblioteca! Enjoy", welcomeMessage);
    }
}
