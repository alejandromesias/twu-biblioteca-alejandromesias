package com.twu.biblioteca;

public class ViewMainMenu {

    public static void display(){
        String[] menuOptions = MainMenu.getOptions();

        System.out.println(menuOptions[0]);
    }
}
