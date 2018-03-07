package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

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
        String title = "** MENU **\n";
        String row0 = "a. List Books\n";
        String row1 = "b. Check out book\n";
        String row2 = "c. Return book\n";
        String row3 = "q. Quit\n";

        String menuContent = title + row0 + row1 + row2 + row3;

        ViewMainMenu.display();
        assertEquals(menuContent, printedOutput.toString());
    }

    @Test
    public void shouldDisplayTheChosenOptionA() {

        String mockInput = "a";
        InputStream menuInput = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(menuInput);

        ViewMainMenu.getAndDisplayUsersChoice();

        String menuChoice = "List Books\n";

        assertTrue(printedOutput.toString().contains(menuChoice));

        System.setIn(System.in);
    }

    @Test
    public void shouldDisplayTheChosenOptionQ() {

        String mockInput = "q";
        InputStream menuInput = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(menuInput);

        ViewMainMenu.getAndDisplayUsersChoice();

        String menuChoice = "Quit\n";

        assertTrue(printedOutput.toString().contains(menuChoice));

        System.setIn(System.in);
    }

    @Test
    public void shouldDisplayInvalidMenuOption() {

        String mockInput = "p";
        InputStream menuInput = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(menuInput);

        ViewMainMenu.getAndDisplayUsersChoice();

        String menuChoice = "Select a valid option!\n";
        assertTrue(printedOutput.toString().contains(menuChoice));

        System.setIn(System.in);
    }
}
