package com.twu.biblioteca;

import java.util.Scanner;

public class FlowControl {

    Scanner scanner = new Scanner(System.in);

    //TODO: Replace this code smell with polymorphism
    public void launch(String code){
        ViewBookLister viewBookLister = new ViewBookLister();
        ViewBookManager viewBookManager = new ViewBookManager(scanner);

        if (code.equals("List Books")){
            viewBookLister.display();
        }
        else if(code.equals("Check out book")){
            viewBookManager.lendingDialog();
        }
        else if(code.equals("Return book")){
            viewBookManager.restoringDialog();
        }
        else if(code.equals("Quit")) {
            BibliotecaApp.stopApp = true;
        }
    }
}
