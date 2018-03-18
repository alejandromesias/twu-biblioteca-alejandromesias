package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Exceptions.WrongIdException;
import com.twu.biblioteca.Exceptions.WrongPasswordException;
import com.twu.biblioteca.Types.UserAccount;

import java.util.ArrayList;

public class UserAuthenticator {
    private Storage storage;
    private UserAccount activeUser;

    public UserAuthenticator(Storage storage) {
        this.storage = storage;
    }

    public UserAccount checkUserCredentials(int bibliotecaId, String password) throws WrongPasswordException, WrongIdException {
        ArrayList<UserAccount> usersList = storage.getUsersList();

        for (UserAccount user : usersList) {
            boolean usersIdMatch = bibliotecaId == user.getBibliotecaId();
            if (usersIdMatch) {
                boolean passwordMatch = password.equals(user.getPassword());
                if (passwordMatch) {
                    this.activeUser = user;
                } else {
                    throw new WrongPasswordException("Wrong Password!");
                }
                break;
            }
        }
        if (activeUser != null) {
            return activeUser;
        } else {
            throw new WrongIdException("Wrong ID!");
        }
    }


    public UserAccount getCurrentActiveUser() {
        return activeUser;
    }

}
