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
            System.out.println("Thank you! Enjoy The book: " + parsedId + ", " + personName);
        }
        else{
            System.out.println("That book is not available: " + parsedId + ", " + personName);
        }
    }

}
