package com.twu.biblioteca;

import java.util.Scanner;

public class ViewCheckOutManager implements Task {
    Depot depot;
    Scanner scanner;

    public ViewCheckOutManager(Depot depot, Scanner scanner) {
        this.depot = depot;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        CheckOutManager checkOutManager = new CheckOutManager(depot);
        System.out.println("** Check Out **");
        System.out.println("Please Enter your Id:");
        String bibliotecaId = scanner.next();
        System.out.println("Please enter your password:");
        String password = scanner.next();
        System.out.println("Please enter the Id of the Movie to Checkout:");
        String MovieId = scanner.next();

        System.out.println(bibliotecaId + password +MovieId);

    }
}
