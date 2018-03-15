package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        ViewMainMenu viewMainMenu = new ViewMainMenu(scanner);

        String title = "** MENU **\n";
        String row0 = "a. List Books\n";
        String row1 = "b. Check out book\n";
        String row2 = "c. Return book\n";
        String row3 = "q. Quit\n";

        String menuContent = title + row0 + row1 + row2 + row3;

        viewMainMenu.display();
        assertEquals(menuContent, printedOutput.toString());
    }

    @Test
    public void shouldDisplayTheChosenOptionA() {
        String mockInput = "a";
        ViewMainMenu viewMainMenu = createViewMaiMenuWithCustomInput(mockInput);

        viewMainMenu.getAndDisplayUsersChoice();

        String menuChoice = "List Books\n";

        assertTrue(printedOutput.toString().contains(menuChoice));

        System.setIn(System.in);
    }


    @Test
    public void shouldDisplayTheChosenOptionQ() {
        String mockInput = "q";
        ViewMainMenu viewMainMenu = createViewMaiMenuWithCustomInput(mockInput);

        viewMainMenu.getAndDisplayUsersChoice();

        String menuChoice = "Quit\n";

        assertTrue(printedOutput.toString().contains(menuChoice));

        System.setIn(System.in);
    }

    @Test
    public void shouldDisplayInvalidMenuOption() {
        String mockInput = "p";
        ViewMainMenu viewMainMenu = createViewMaiMenuWithCustomInput(mockInput);

        viewMainMenu.getAndDisplayUsersChoice();

        String menuChoice = "Select a valid option!\n";
        assertTrue(printedOutput.toString().contains(menuChoice));

        System.setIn(System.in);
    }

    private ViewMainMenu createViewMaiMenuWithCustomInput(String mockInput) {
        InputStream menuInput = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        return new ViewMainMenu(scanner);
    }
}
