package com.twu.biblioteca;

import java.util.Scanner;

public class ViewBookManager {

    public static void getDataForLending(){
        System.out.println("Enter the ID of the book to check out");

        Scanner scan = new Scanner(System.in);
        String requestedBookId = scan.next();
        int parsedId = Integer.parseInt(requestedBookId);

        System.out.println("Enter your Name");
        String personName = scan.next();

        System.out.println("Data: " + parsedId + personName);

        /*if (BookManager.lend(parsedId,personName)){
            System.out.println("Success");
        }
        else{
            System.out.println("error for: " + parsedId + personName);
        }*/
    }

}
