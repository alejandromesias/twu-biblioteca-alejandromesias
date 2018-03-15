package com.twu.biblioteca;

import java.util.ArrayList;

public class Depot {

    private ArrayList<UserAccount> usersList;

    public Depot() {
        this.usersList = buildUsers();
    }

    public ArrayList<UserAccount> getUsersList() {
        return usersList;
    }

    private ArrayList<UserAccount> buildUsers(){
        ArrayList<UserAccount> users = new ArrayList<UserAccount>();
        UserAccount user;
        user = new UserAccount(1112222,
                "Password0",
                "User0",
                "user0@email.com",
                "0999999999");
        users.add(user);
        user = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        users.add(user);
        user = new UserAccount(2223333,
                "Password2",
                "User2",
                "user2@email.com",
                "0777777777");
        users.add(user);

        return users;
    }
}
