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
    public void shouldGetDataFromTheUserForLending() {

        String bookId = "3\nJohn Doe";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);

        ViewBookManager.getDataForLending();

        String feedback = "Data is: 3";

        assertTrue(printedOutput.toString().contains(feedback));

        System.setIn(System.in);
    }
}
