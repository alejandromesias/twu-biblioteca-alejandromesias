package com.twu.biblioteca;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {

        FlowControl flowControl = new FlowControl();
        ViewMainMenu viewMainMenu = new ViewMainMenu();
        ViewMessagesBiblio viewMessagesBiblio = new ViewMessagesBiblio();


        viewMessagesBiblio.welcome();

        while(!stopApp) {
            System.out.println("--------------");

            viewMainMenu.display();

            viewMainMenu.getAndDisplayUsersChoice();
        }
    }


}
