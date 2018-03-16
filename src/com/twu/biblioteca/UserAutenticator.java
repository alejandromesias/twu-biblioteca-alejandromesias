package com.twu.biblioteca;

import java.util.ArrayList;

public class UserAutenticator {
    private Depot depot;
    private UserAccount activeUser;

    public UserAutenticator(Depot depot) {
        this.depot = depot;
    }

    public UserAccount checkCredentials(int bibliotecaId, String password){
        ArrayList<UserAccount> usersList = depot.getUsersList();

        for (UserAccount user : usersList) {
            boolean usersIdMatch = bibliotecaId == user.getBibliotecaId();
            if(usersIdMatch){
                boolean passwordMatch = password == user.getPassword();
                if(passwordMatch){
                    this.activeUser = user;
                }

            }
        }

        return  activeUser;
    }

}
