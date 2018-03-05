package com.twu.biblioteca;


import java.util.ArrayList;

public class MainMenu {

    public static ArrayList<MenuOption> getOptions() {

        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        MenuOption option0 = new MenuOption("List Books", "a");
        MenuOption option1 = new MenuOption("Second option", "b");
        options.add(option0);
        options.add(option1);

        return options;
    }

    public static String retrieveOption(String selectedOption){
        return "";
    }
}
