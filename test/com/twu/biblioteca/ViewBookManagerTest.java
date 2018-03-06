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

public class ViewBookManagerTest {

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
    public void shouldGetDataFromTheUserForSuccessfulLending() {

        String bookId = "3\nDani";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);

        ViewBookManager.lendingDialog();

        String expectedMessage = "Thank you!";
        String expectedData = "3, Dani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }
}
