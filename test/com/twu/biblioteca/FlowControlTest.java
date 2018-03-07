package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FlowControlTest {

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
    public void shouldLaunchTheViewBookLister() {
        FlowControl.launch("List Books");

        String row0 = "mockBook0      author0        2000 \n";
        String row1 = "mockBook1      author1        2001 \n";
        String row2 = "mockBook2      author2        2002 \n";
        String listContent = row0 + row1 + row2;
        assertEquals(listContent, printedOutput.toString());
    }

    @Test
    public void shouldLaunchTheViewBookManager() {
        /*FlowControl.launch("Check out book");

        ViewBookManagerTest managerTest = new ViewBookManagerTest();

        managerTest.shouldGetDataFromTheUserForSuccessfulLending();*/
    }
}
