package com.twu.biblioteca;

import com.twu.biblioteca.Views.Task;
import com.twu.biblioteca.Views.TaskFactory;

import java.util.Scanner;

public class BibliotecaApp {

    public static boolean stopApp;

    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        TaskFactory taskFactory = new TaskFactory(storage, scanner);

        System.out.println("Welcome to Biblioteca! Enjoy");
        while (true) {
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
