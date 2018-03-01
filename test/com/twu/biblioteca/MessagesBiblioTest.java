package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessagesBiblioTest {
    @Test
    public void shouldReturnWelcome() {
        String welcomeMessage = MessagesBiblio.welcome();

        assertEquals(welcomeMessage,"Welcome to Biblioteca! Enjoy");
    }
}
