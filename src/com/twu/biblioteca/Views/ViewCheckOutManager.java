package com.twu.biblioteca.Views;

import com.twu.biblioteca.*;
import com.twu.biblioteca.Controllers.CheckOutManager;
import com.twu.biblioteca.Controllers.UserAuthenticator;
import com.twu.biblioteca.Exceptions.WrongIdException;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Exceptions.WrongPasswordException;
import com.twu.biblioteca.Types.UserAccount;

import java.util.Scanner;

public class ViewCheckOutManager implements Task {
    Depot depot;
    Scanner scanner;

    public ViewCheckOutManager(Depot depot, Scanner scanner) {
        this.depot = depot;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        CheckOutManager checkOutManager = new CheckOutManager(depot);
        UserAuthenticator authenticator = new UserAuthenticator(depot);

        System.out.println("** Check Out **");
        try{
            System.out.println("Please Enter your Id:");
            int bibliotecaId = Integer.parseInt(scanner.next());
            System.out.println("Please enter your password:");
            String password = scanner.next();
            UserAccount verifiedUser = authenticator.checkUserCredentials(bibliotecaId,password);
            try {
                System.out.println("Please enter the Id of the Movie to Checkout:");
                int movieId = Integer.parseInt(scanner.next());
                checkOutManager.performCheckOut(verifiedUser,movieId);
                System.out.println("Thank you Enjoy!");
            }
            catch(NumberFormatException exception){
                System.out.println("Invalid movie ID format");
            }
            catch(WrongItemIdException exception){
                System.out.println(exception.getMessage());
            }
        }catch(NumberFormatException exception){
            System.out.println("Invalid biblioteca ID format");
        }catch(WrongIdException wrongId){
            System.out.println(wrongId.getMessage());
        }catch(WrongPasswordException wrongPassword){
            System.out.println(wrongPassword.getMessage());
        }
    }
}
