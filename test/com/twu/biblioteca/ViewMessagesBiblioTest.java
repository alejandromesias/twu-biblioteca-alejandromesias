package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ViewMessagesBiblioTest {

    private final ByteArrayOutputStream printedOutput = new ByteArrayOutputStream();
    ViewMessagesBiblio viewMessagesBiblio = new ViewMessagesBiblio();
    MessagesBiblio messages = new MessagesBiblio();

    @Before
    public void captureStream() {
        System.setOut(new PrintStream(printedOutput));
    }

    @After
    public void restoreStream() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayTheWelcomeMessage() {
        String wellcomeMessage = messages.welcome()+"\n";
        viewMessagesBiblio.welcome();
        assertEquals(wellcomeMessage, printedOutput.toString());
    }
}
