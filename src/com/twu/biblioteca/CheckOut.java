package com.twu.biblioteca;

public class CheckOut {
    private UserAccount userAccount;
    private Movie lentMovie;

    private boolean checkOutActive;

    public CheckOut(UserAccount userAccount, Movie movie) {
        this.userAccount = userAccount;
        this.lentMovie = movie;
        this.checkOutActive = true;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Movie getLentMovie() {
        return lentMovie;
    }

    public boolean isCheckOutActive() {
        return checkOutActive;
    }

    public void setCheckOutActive(boolean checkOutActive) {
        this.checkOutActive = checkOutActive;
    }
}
