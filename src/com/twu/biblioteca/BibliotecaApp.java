package com.twu.biblioteca;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {

        ViewMainMenu viewMainMenu = new ViewMainMenu();

        ViewMessagesBiblio.welcome();

        while(!stopApp) {
            System.out.println("--------------");

            viewMainMenu.display();

            viewMainMenu.getAndDisplayUsersChoice();
        }
    }


}
