package com.twu.biblioteca;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {

        ViewMessagesBiblio.welcome();

        while(!stopApp) {
            System.out.println("--------------");

            ViewMainMenu.display();

            ViewMainMenu.getAndDisplayUsersChoice();
        }
    }


}
