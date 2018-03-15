package com.twu.biblioteca;

import java.util.Scanner;

public class ViewBookManager {
    MessagesBiblio messages = new MessagesBiblio();
    Scanner scanner;

    public ViewBookManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void requestInfoForLending(){
        BookManager bookManager = new BookManager();

        System.out.println("Enter your Name");
        String personName = scanner.next();

        System.out.println(messages.enterIdForCheckout());
        String requestedBookId = scanner.next();
        try {
            int parsedId = Integer.parseInt(requestedBookId);
            boolean bookWasLent = bookManager.lend(parsedId, personName);
            if (bookWasLent) {
                System.out.println("Thank you! Enjoy the book: " + parsedId + ", " + personName);
            } else {
                System.out.println("That book is not available: " + parsedId + ", " + personName);
            }
        }catch(Exception e){
            System.out.println("Dato no válido, " + personName);
        }
    }

    public void requestInfoForRestoring(){
        BookManager bookManager = new BookManager();

        System.out.println("Enter your Name");
        String personName = scanner.next();

        System.out.println("Enter the ID of the book you are returning");
        String requestedBookId = scanner.next();
        try{
            int parsedId = Integer.parseInt(requestedBookId);
            boolean bookWasRestored = bookManager.restore(parsedId,personName);
            if (bookWasRestored){
                System.out.println("Thank you for returning the book: " + parsedId + ", " + personName);
            }
            else{
                System.out.println("That is not a valid book return! " + parsedId + ", " + personName);
            }
        }catch(Exception e){
            System.out.println("Dato no válido, " + personName);
        }
    }

}
