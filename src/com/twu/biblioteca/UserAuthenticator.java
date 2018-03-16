package com.twu.biblioteca;

import java.util.ArrayList;

public class UserAuthenticator {
    private Depot depot;
    private UserAccount activeUser;

    public UserAuthenticator(Depot depot) {
        this.depot = depot;
    }

    public UserAccount checkCredentials(int bibliotecaId, String password){
        ArrayList<UserAccount> usersList = depot.getUsersList();

        for (UserAccount user : usersList) {
            boolean usersIdMatch = bibliotecaId == user.getBibliotecaId();
            if(usersIdMatch){
                boolean passwordMatch = password.equals(user.getPassword());
                if(passwordMatch){
                    this.activeUser = user;
                }
            }
        }
        return  activeUser;
    }

    public UserAccount getCurrentActiveUser() {
        return activeUser;
    }

}
