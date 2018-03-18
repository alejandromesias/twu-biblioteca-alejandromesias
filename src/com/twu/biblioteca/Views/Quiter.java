package com.twu.biblioteca.Views;

public class Quiter implements Task {
    @Override
    public void execute() {
        System.out.println("Thank you, bye");
        System.exit(0);
    }
}
