package com.twu.biblioteca;

public class ViewMainMenu {

    public static void display(){
        String[] menuOptions = MainMenu.getOptions();

        int optionIndex = 1;
        for (String option: menuOptions) {
            System.out.println(optionIndex + ". " + option);
        }

    }
}
