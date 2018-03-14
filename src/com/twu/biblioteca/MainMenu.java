package com.twu.biblioteca;


import java.util.ArrayList;

public class MainMenu {

    public ArrayList<MenuOption> getOptions() {

        ArrayList<MenuOption> options = buildOptions();

        return options;
    }

    public String retrieveOption(String selectedOption){

        ArrayList<MenuOption> options = buildOptions();

        for (MenuOption option : options) {
            if(option.getOptionId().equals(selectedOption)){
                return option.getOptionLabel();
            }
        }

        return "not found";
    }

    private ArrayList<MenuOption> buildOptions() {
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        MenuOption option0 = new MenuOption("List Books", "a");
        MenuOption option1 = new MenuOption("Check out book", "b");
        MenuOption option2 = new MenuOption("Return book", "c");
        MenuOption option3 = new MenuOption("Quit", "q");
        options.add(option0);
        options.add(option1);
        options.add(option2);
        options.add(option3);

        return options;
    }
}
