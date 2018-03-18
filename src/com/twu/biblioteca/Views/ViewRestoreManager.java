package com.twu.biblioteca.Views;

import com.twu.biblioteca.Controllers.CheckOutManager;
import com.twu.biblioteca.Controllers.UserAuthenticator;
import com.twu.biblioteca.Depot;

import java.util.Scanner;

public class ViewRestoreManager implements Task {
    private Depot depot;
    private Scanner scanner;

    public ViewRestoreManager(Depot depot, Scanner scanner) {
        this.depot = depot;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        CheckOutManager checkOutManager = new CheckOutManager(depot);
        UserAuthenticator authenticator = new UserAuthenticator(depot);
        System.out.println("here goes the restore");

    }
}