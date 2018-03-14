package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;

public class ViewBookManagerTest {

    private final ByteArrayOutputStream printedOutput = new ByteArrayOutputStream();

    BookManager bookManager = new BookManager();
    BibliotecaStorage storage = new BibliotecaStorage();

    @Before
    public void captureStream() {
        System.setOut(new PrintStream(printedOutput));
        storage.initialize();
    }

    @After
    public void restoreStream() {
        System.setOut(System.out);
    }

    @Test
    public void shouldGetDataFromTheUserForSuccessfulLending() {

        String bookId = "Dani\n3";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        ViewBookManager viewBookManager = new ViewBookManager(scanner);

        viewBookManager.lendingDialog();

        String expectedMessage = "Enjoy the book";
        String expectedData = "3, Dani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }

    @Test
    public void shouldGetDataFromTheUserForFailedLending() {

        String bookId = "Dani\n9";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        ViewBookManager viewBookManager = new ViewBookManager(scanner);


        viewBookManager.lendingDialog();

        String expectedMessage = "not available";
        String expectedData = "9, Dani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }

    @Test
    public void shouldValidateDataTypeFromTheUserOnFailedLending() {

        String bookId = "Dani\nQ";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        ViewBookManager viewBookManager = new ViewBookManager(scanner);


        viewBookManager.lendingDialog();

        String expectedMessage = "no válido";
        String expectedData = ", Dani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }


    @Test
    public void shouldGetDataFromTheUserForSuccessfulRestoring() {

        bookManager.lend(3,"Dani");

        String bookId = "Dani\n3";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        ViewBookManager viewBookManager = new ViewBookManager(scanner);


        viewBookManager.restoringDialog();

        String expectedMessage = "returning the book";
        String expectedData = "3, Dani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }

    @Test
    public void shouldGetDataFromTheUserForFailedRestoring() {

        bookManager.lend(3,"Dani");

        String bookId = "Mani\n3";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        ViewBookManager viewBookManager = new ViewBookManager(scanner);


        viewBookManager.restoringDialog();

        String expectedMessage = "not a valid book";
        String expectedData = "3, Mani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }

    @Test
    public void shouldValidateDataTypeFromTheUserOnFailedRestoring() {

        String bookId = "Dani\nQ";
        InputStream menuInput = new ByteArrayInputStream(bookId.getBytes());
        System.setIn(menuInput);
        Scanner scanner = new Scanner(System.in);
        ViewBookManager viewBookManager = new ViewBookManager(scanner);


        viewBookManager.restoringDialog();

        String expectedMessage = "no válido";
        String expectedData = ", Dani";

        assertTrue(printedOutput.toString().contains(expectedMessage));
        assertTrue(printedOutput.toString().contains(expectedData));

        System.setIn(System.in);
    }


}
