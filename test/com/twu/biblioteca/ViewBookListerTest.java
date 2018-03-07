package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ViewBookListerTest {

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
    public void shouldDisplayTheBookList() {

        String header = "ID   Book Name      Author         Year \n";
        String row0   = "2    mockBook0      author0        2000 \n";
        String row1   = "3    mockBook1      author1        2001 \n";
        String row2   = "4    mockBook2      author2        2002 \n";
        String listContent = header + row0 + row1 + row2;

        BibliotecaStorage.initialize();

        ViewBookLister.display();
        assertEquals(listContent, printedOutput.toString());
    }

}
