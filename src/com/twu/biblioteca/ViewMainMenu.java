package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMainMenu {
    MessagesBiblio messages = new MessagesBiblio();

    public void display(){
        System.out.println("** MENU **");

        MainMenu mainMenu = new MainMenu();
        ArrayList<MenuOption> menuOptions = mainMenu.getOptions();

        for (MenuOption option: menuOptions) {
            System.out.println(option.getOptionId() + ". " + option.getOptionLabel());
        }

    }

    public void getAndDisplayUsersChoice() {
        MainMenu mainMenu = new MainMenu();
        FlowControl flowControl = new FlowControl();
        System.out.println(messages.pickAMenuChoice());

        Scanner scan = new Scanner(System.in);
        String userChoice = scan.next();

        String optionLabel = mainMenu.retrieveOption(userChoice);
        if (optionLabel.equals("not found")) {
            System.out.println("Select a valid option!");
        }else {
            System.out.println(optionLabel);
            flowControl.launch(optionLabel);
        }
    }
}
