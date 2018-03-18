package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {
        ViewMessagesBiblio viewMessagesBiblio = new ViewMessagesBiblio();
        Depot depot = new Depot();
        Scanner scanner = new Scanner(System.in);
        TaskFactory taskFactory = new TaskFactory(depot,scanner);

        viewMessagesBiblio.welcome();
        while(true) {
            System.out.println("--------------");
            System.out.println(taskFactory.toString());
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

}
