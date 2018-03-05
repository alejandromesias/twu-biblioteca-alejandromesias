package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewMainMenu {

    public static void display(){
        ArrayList<MenuOption> menuOptions = MainMenu.getOptions();

        for (MenuOption option: menuOptions) {
            System.out.println(option.getOptionId() + ". " + option.getOptionLabel());
        }

    }

    public static void getAndDisplayUserChoice() {

    }
}
