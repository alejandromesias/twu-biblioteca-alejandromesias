package com.twu.biblioteca;

public class CheckOutManager {

    private Depot depot;
    private UserAuthenticator authenticator;


    public CheckOutManager(Depot depot) {
        this.depot = depot;
        this.authenticator = new UserAuthenticator(depot);
    }

    public void performCheckOut(UserAccount user, Movie movie){
        //UserAccount correctUser = authenticator.checkUserCredentials();
    };

}
