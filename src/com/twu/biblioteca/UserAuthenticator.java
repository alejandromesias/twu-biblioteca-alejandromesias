package com.twu.biblioteca;

import java.util.ArrayList;

public class UserAuthenticator {
    private Depot depot;
    private UserAccount activeUser;

    public UserAuthenticator(Depot depot) {
        this.depot = depot;
    }

    public UserAccount checkUserCredentials(int bibliotecaId, String password) throws WrongPasswordException, WrongIdException{
        ArrayList<UserAccount> usersList = depot.getUsersList();

        for (UserAccount user : usersList) {
            boolean usersIdMatch = bibliotecaId == user.getBibliotecaId();
            if(usersIdMatch) {
                boolean passwordMatch = password.equals(user.getPassword());
                if (passwordMatch) {
                    this.activeUser = user;
                } else {
                    throw new WrongPasswordException("Wrong Password!");
                }
                break;
            }
        }
        if(activeUser != null) {
            return activeUser;
        }else{
            throw new WrongIdException("Wrong ID!");
        }
    }


    public UserAccount getCurrentActiveUser() {
        return activeUser;
    }

}
