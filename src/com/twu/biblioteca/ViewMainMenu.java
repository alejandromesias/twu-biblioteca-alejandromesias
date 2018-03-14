package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMainMenu {
    Scanner scanner;

    MessagesBiblio messages = new MessagesBiblio();
    MainMenu mainMenu = new MainMenu();
    FlowControl flowControl = new FlowControl();

    public ViewMainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void display(){
        System.out.println("** MENU **");

        ArrayList<MenuOption> menuOptions = mainMenu.getOptions();

        for (MenuOption option: menuOptions) {
            System.out.println(option.getOptionId() + ". " + option.getOptionLabel());
        }

    }

    public void getAndDisplayUsersChoice() {

        System.out.println(messages.printmenuInstructions());
        String userChoice = scanner.next();

        String optionLabel = mainMenu.retrieveOption(userChoice);
        if (optionLabel.equals("not found")) {
            System.out.println("Select a valid option!");
        }else {
            System.out.println(optionLabel);
            flowControl.launch(optionLabel);
        }
    }
}
