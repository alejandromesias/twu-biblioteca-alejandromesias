package com.twu.biblioteca;


import java.util.ArrayList;

public class MainMenu {

    public static ArrayList<MenuOption> getOptions() {

        ArrayList<MenuOption> options = buildOptions();

        return options;
    }

    public static String retrieveOption(String selectedOption){

        ArrayList<MenuOption> options = buildOptions();

        for (MenuOption option : options) {
            if(option.getOptionId().equals(selectedOption)){
                return option.getOptionLabel();
            }
        }

        return "not found";
    }

    private static ArrayList<MenuOption> buildOptions() {
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        MenuOption option0 = new MenuOption("List Books", "a");
        MenuOption option1 = new MenuOption("Check out book", "b");
        MenuOption option2 = new MenuOption("Quit", "q");
        options.add(option0);
        options.add(option1);
        options.add(option2);

        return options;
    }
}
