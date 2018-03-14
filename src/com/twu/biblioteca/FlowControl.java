package com.twu.biblioteca;

public class FlowControl {

    //TODO: Replace this code smell with polymorphism
    public void launch(String code){
        ViewBookLister viewBookLister = new ViewBookLister();
        ViewBookManager viewBookManager = new ViewBookManager();

        if (code == "List Books"){
            viewBookLister.display();
        }
        else if(code == "Check out book"){
            viewBookManager.lendingDialog();
        }
        else if(code == "Return book"){
            viewBookManager.restoringDialog();
        }
        else if(code == "Quit") {
            BibliotecaApp.stopApp = true;
        }
    }
}
