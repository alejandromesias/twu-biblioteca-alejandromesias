package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {

        FlowControl flowControl = new FlowControl();
        Scanner scanner = new Scanner(System.in);
        ViewMainMenu viewMainMenu = new ViewMainMenu(scanner);
        ViewMessagesBiblio viewMessagesBiblio = new ViewMessagesBiblio();


        viewMessagesBiblio.welcome();

        while(!stopApp) {
            System.out.println("--------------");

            viewMainMenu.display();

            viewMainMenu.getAndDisplayUsersChoice();
        }
    }


}
