package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ViewMainMenu viewMainMenu = new ViewMainMenu(scanner);
        ViewMessagesBiblio viewMessagesBiblio = new ViewMessagesBiblio();
        Depot depot = new Depot();

        viewMessagesBiblio.welcome();
        System.out.println("choose an option");
        String input = scanner.nextLine();
        TaskFactory taskFactory = new TaskFactory();

        try {
            Task taskToExecute = taskFactory.getRequestedTask(input);
            taskToExecute.execute(depot);
        }catch(Exception problem){
            System.out.println(problem.getMessage());
        }
    }

        /*while(!stopApp) {
            System.out.println("--------------");

            //viewMainMenu.display();

            //viewMainMenu.getAndDisplayUsersChoice();
        }*/

}
