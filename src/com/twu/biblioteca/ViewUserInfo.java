package com.twu.biblioteca;

import java.util.Scanner;

public class ViewUserInfo implements Task{
    private Depot depot;
    private Scanner scanner;

    public ViewUserInfo(Depot depot, Scanner scanner) {
        this.depot = depot;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Here goes the User INfo");
    }
}
