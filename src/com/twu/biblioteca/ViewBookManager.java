package com.twu.biblioteca;

import java.util.Scanner;

public class ViewBookManager {

    public static void lendingDialog(){
        System.out.println("Enter the ID of the book to check out");

        Scanner scan = new Scanner(System.in);
        String requestedBookId = scan.next();
        int parsedId = Integer.parseInt(requestedBookId);

        System.out.println("Enter your Name");
        String personName = scan.next();


        if (BookManager.lend(parsedId,personName)){
            System.out.println("Thank you! Enjoy The book: " + parsedId + ", " + personName);
        }
        else{
            System.out.println("That book is not available: " + parsedId + ", " + personName);
        }
    }

}
