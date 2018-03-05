package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewMainMenu {

    public static void display(){
        ArrayList<MenuOption> menuOptions = MainMenu.getOptions();

        int optionIndex = 1;
        for (MenuOption option: menuOptions) {
            System.out.println(optionIndex + ". " + option.getOptionLabel());
        }

    }
}
