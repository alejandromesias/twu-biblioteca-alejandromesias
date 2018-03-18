package com.twu.biblioteca.Views;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Exceptions.WrongIdException;
import com.twu.biblioteca.Exceptions.WrongPasswordException;
import com.twu.biblioteca.Types.UserAccount;
import com.twu.biblioteca.Controllers.UserAuthenticator;

import java.util.Scanner;

public class ViewUserInfo implements Task {
    private Storage storage;
    private Scanner scanner;

    public ViewUserInfo(Storage storage, Scanner scanner) {
        this.storage = storage;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        UserAuthenticator authenticator = new UserAuthenticator(storage);

        System.out.println("** User Information **");
        try {
            System.out.println("Please Enter your Id:");
            int bibliotecaId = Integer.parseInt(scanner.next());
            System.out.println("Please enter your password:");
            String password = scanner.next();
            UserAccount verifiedUser = authenticator.checkUserCredentials(bibliotecaId, password);
            System.out.println(verifiedUser.toString());
        } catch (NumberFormatException exception) {
            System.out.println("Invalid biblioteca ID format");
        } catch (WrongIdException wrongId) {
            System.out.println(wrongId.getMessage());
        } catch (WrongPasswordException wrongPassword) {
            System.out.println(wrongPassword.getMessage());
        }
    }
}
