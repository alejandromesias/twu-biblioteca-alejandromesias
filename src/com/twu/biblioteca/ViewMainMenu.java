package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMainMenu {

    public static void display(){
        ArrayList<MenuOption> menuOptions = MainMenu.getOptions();

        for (MenuOption option: menuOptions) {
            System.out.println(option.getOptionId() + ". " + option.getOptionLabel());
        }

    }

    public static void getAndDisplayUserChoice() {
        Scanner scan = new Scanner(System.in);
        String userChoice = scan.next();

        System.out.println("List Books");
    }
}
