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
    private Storage storage;
    private Scanner scanner;
    private String itemType;

    public ViewCheckOutManager(Storage storage, Scanner scanner, String itemType) {
        this.storage = storage;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        CheckOutManager checkOutManager = new CheckOutManager(storage, "movie");
        UserAuthenticator authenticator = new UserAuthenticator(storage);

        System.out.println("** Check Out **");
        try {
            System.out.println("Please Enter your Id:");
            int bibliotecaId = Integer.parseInt(scanner.next());
            System.out.println("Please enter your password:");
            String password = scanner.next();
            UserAccount verifiedUser = authenticator.checkUserCredentials(bibliotecaId, password);
            try {
                System.out.println("Please enter the Id of the "+ itemType +" to Checkout:");
                int itemId = Integer.parseInt(scanner.next());
                checkOutManager.performCheckOut(verifiedUser, itemId);
                System.out.println("Thank you Enjoy!");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid item ID format");
            } catch (WrongItemIdException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } catch (NumberFormatException exception) {
            System.out.println("Invalid biblioteca ID format");
        } catch (WrongIdException wrongId) {
            System.out.println(wrongId.getMessage());
        } catch (WrongPasswordException wrongPassword) {
            System.out.println(wrongPassword.getMessage());
        }
    }
}
