package com.twu.biblioteca;

public class FlowControl {

    //TODO: Replace this code smell with polymorphism
    public static void launch(String code){
        if (code == "List Books"){
            ViewBookLister.display();
        }
        else if(code == "Check out book"){
            ViewBookManager.lendingDialog();
        }
        else if(code == "Quit") {
            BibliotecaApp.stopApp = true;
        }
    }
}
