package com.twu.biblioteca.Views;

import com.twu.biblioteca.Depot;
import com.twu.biblioteca.Types.MenuOption;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskFactory {
    private Depot depot;
    private Scanner scanner;
    private ArrayList<MenuOption> optionsList;

    public TaskFactory(Depot depot, Scanner scanner) {
        this.depot = depot;
        this.scanner = scanner;
        this.optionsList = buildOptions();
    }

    public Task getRequestedTask(String option) throws Exception {

        switch (option) {
            case "a":
                return new ViewMovieLister(depot);
            case "b":
                return new ViewCheckOutManager(depot, scanner);
            case "c":
                return new ViewRestoreManager(depot, scanner);
            case "u":
                return new ViewUserInfo(depot, scanner);
            case "q":
                return new Quiter();
            default:
                throw new Exception("Select a valid option!");
        }

    }

    private ArrayList<MenuOption> buildOptions() {
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        MenuOption listMovie = new MenuOption("List movies", "a");
        MenuOption checkoutMovie = new MenuOption("Check out movies", "b");
        MenuOption returnMovie = new MenuOption("Return movie", "c");
        MenuOption userInfo = new MenuOption("View User Info", "u");
        MenuOption quit = new MenuOption("Quit", "q");
        options.add(listMovie);
        options.add(checkoutMovie);
        options.add(returnMovie);
        options.add(userInfo);
        options.add(quit);

        return options;
    }

    @Override
    public String toString() {
        String printedMenu = "";
        String format = "%s. %s%n";
        for (MenuOption option : optionsList) {
            printedMenu += String.format(format,
                    option.getOptionId(),
                    option.getOptionLabel());
        }
        return printedMenu;
    }
}
