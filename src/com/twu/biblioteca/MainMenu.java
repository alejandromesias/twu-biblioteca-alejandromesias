package com.twu.biblioteca;


import java.util.ArrayList;

public class MainMenu {

    public static ArrayList<MenuOption> getOptions() {

        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        MenuOption option0 = new MenuOption("", "a");
        options.add(option0);

        return options;
    }
}
