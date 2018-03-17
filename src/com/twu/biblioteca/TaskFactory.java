package com.twu.biblioteca;

import java.util.Scanner;

public class TaskFactory {
    private Depot depot;
    private Scanner scanner;

    public TaskFactory(Depot depot, Scanner scanner) {
        this.depot = depot;
        this.scanner = scanner;
    }

    public Task getRequestedTask(String option) throws Exception {

        switch (option){
            case "a":
                return new ViewMovieLister(depot);
            case "b":
                return new ViewCheckOutManager(depot,scanner);
            default:
                throw new Exception("Select a valid option!");
        }

    }
}
