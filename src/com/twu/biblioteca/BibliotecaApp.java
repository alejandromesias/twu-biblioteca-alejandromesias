package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {


        //ViewMainMenu viewMainMenu = new ViewMainMenu(scanner);
        ViewMessagesBiblio viewMessagesBiblio = new ViewMessagesBiblio();
        Depot depot = new Depot();
        Scanner scanner = new Scanner(System.in);
        TaskFactory taskFactory = new TaskFactory(depot,scanner);

        viewMessagesBiblio.welcome();
        while(true) {
            System.out.println("choose an option");
            String input = scanner.next();
            try {
                Task taskToExecute = taskFactory.getRequestedTask(input);
                taskToExecute.execute();
            } catch (Exception problem) {
                System.out.println(problem.getMessage());
            }
        }
    }

        /*while(!stopApp) {
            System.out.println("--------------");

            //viewMainMenu.display();

            //viewMainMenu.getAndDisplayUsersChoice();
        }*/

}
