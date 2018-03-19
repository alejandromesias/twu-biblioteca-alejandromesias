package com.twu.biblioteca.Views;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Types.MenuOption;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskFactory {
    private Storage storage;
    private Scanner scanner;
    private ArrayList<MenuOption> optionsList;

    public TaskFactory(Storage storage, Scanner scanner) {
        this.storage = storage;
        this.scanner = scanner;
        this.optionsList = buildOptions();
    }

    public Task getRequestedTask(String option) throws Exception {

        switch (option) {
            case "a":
                return new ViewMovieLister(storage);
            case "b":
                return new ViewCheckOutManager(storage, scanner);
            case "c":
                return new ViewRestoreManager(storage, scanner);
            case "d":
                return new ViewBookLister(storage);
            case "u":
                return new ViewUserInfo(storage, scanner);
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
        MenuOption listBook = new MenuOption("List books", "d");
        MenuOption userInfo = new MenuOption("View User Info", "u");
        MenuOption quit = new MenuOption("Quit", "q");
        options.add(listMovie);
        options.add(checkoutMovie);
        options.add(returnMovie);
        options.add(listBook);
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
