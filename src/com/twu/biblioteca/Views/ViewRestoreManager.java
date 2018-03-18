package com.twu.biblioteca.Views;

import com.twu.biblioteca.Controllers.RestoreManager;
import com.twu.biblioteca.Controllers.UserAuthenticator;
import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Exceptions.WrongIdException;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Exceptions.WrongPasswordException;
import com.twu.biblioteca.Types.UserAccount;

import java.util.Scanner;

public class ViewRestoreManager implements Task {
    private Storage storage;
    private Scanner scanner;

    public ViewRestoreManager(Storage storage, Scanner scanner) {
        this.storage = storage;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        RestoreManager restorer = new RestoreManager(storage);
        UserAuthenticator authenticator = new UserAuthenticator(storage);

        System.out.println("** Check Out **");
        try {
            System.out.println("Please Enter your Id:");
            int bibliotecaId = Integer.parseInt(scanner.next());
            System.out.println("Please enter your password:");
            String password = scanner.next();
            UserAccount verifiedUser = authenticator.checkUserCredentials(bibliotecaId, password);
            try {
                System.out.println("Please enter the Id of the returning Movie:");
                int movieId = Integer.parseInt(scanner.next());
                restorer.performRestore(verifiedUser, movieId);
                System.out.println("Thank you for returning the Book!");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid movie ID format");
            } catch (WrongItemIdException exception) {
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