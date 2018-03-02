package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessagesBiblioTest {
    @Test
    public void shouldReturnTheWelcomeMessage() {
        String welcomeMessage = MessagesBiblio.welcome();

        assertEquals("Welcome to Biblioteca! Enjoy", welcomeMessage);
    }
}
