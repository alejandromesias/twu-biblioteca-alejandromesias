package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ViewMainMenuTest {

    private final ByteArrayOutputStream printedOutput = new ByteArrayOutputStream();

    @Before
    public void captureStream() {
        System.setOut(new PrintStream(printedOutput));
    }

    @After
    public void restoreStream() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayTheMainMenu() {

        String row0 = "a. List Books\n";
        String row1 = "b. Second option\n";

        String menuContent = row0;

        ViewMainMenu.display();
        assertEquals(menuContent, printedOutput.toString());
    }
}
