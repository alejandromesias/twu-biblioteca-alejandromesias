package com.twu.biblioteca;

import javax.jws.soap.SOAPBinding;
import java.net.Authenticator;
import java.text.ParseException;
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
            UserAccount verifyedUser = authenticator.checkUserCredentials(bibliotecaId,password);
            try {
                System.out.println("Please enter the Id of the Movie to Checkout:");
                int movieId = Integer.parseInt(scanner.next());
                checkOutManager.performCheckOut(verifyedUser,movieId);
            }
            catch(NumberFormatException exception){
                System.out.println("Invalid movie ID format");
            }
            catch(Exception excepction){
                excepction.getMessage();
            }
        }catch(NumberFormatException exception){
            System.out.println("Invalid biblioteca ID format");
        }catch(NullPointerException exception){
            System.out.println("Invalid credentials");
        }
    }
}
