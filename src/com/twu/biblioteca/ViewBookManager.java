package com.twu.biblioteca;

import java.util.Scanner;

public class ViewBookManager {

    public static void lendingDialog(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your Name");
        String personName = scan.next();

        System.out.println(MessagesBiblio.enterIdForCheckout());
        String requestedBookId = scan.next();
        int parsedId = Integer.parseInt(requestedBookId);


        if (BookManager.lend(parsedId,personName)){
            System.out.println("Thank you! Enjoy the book: " + parsedId + ", " + personName);
        }
        else{
            System.out.println("That book is not available: " + parsedId + ", " + personName);
        }
    }

    public static void restoringDialog(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your Name");
        String personName = scan.next();

        System.out.println("Enter the ID of the book you are returning");
        String requestedBookId = scan.next();
        int parsedId = Integer.parseInt(requestedBookId);


        if (BookManager.restore(parsedId,personName)){
            System.out.println("Thank you for returning the book: " + parsedId + ", " + personName);
        }
        else{
            System.out.println("That is not a valid book return! " + parsedId + ", " + personName);
        }
    }

}
