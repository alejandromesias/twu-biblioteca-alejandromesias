package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        ViewMessagesBiblio.welcome();

        while(true) {
            System.out.println("--------------");

            ViewMainMenu.display();

            ViewMainMenu.getAndDisplayUsersChoice();
        }
    }


}
