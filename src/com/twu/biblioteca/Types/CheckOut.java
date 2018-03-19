package com.twu.biblioteca.Types;

public class CheckOut {
    private UserAccount userAccount;
    private Item lentItem;

    private boolean checkOutActive;

    public CheckOut(UserAccount userAccount, Item item) {
        this.userAccount = userAccount;
        this.lentItem = item;
        this.checkOutActive = true;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Item getLentMovie() {
        return lentItem;
    }

    public boolean isCheckOutActive() {
        return checkOutActive;
    }

    public void setCheckOutActive(boolean checkOutActive) {
        this.checkOutActive = checkOutActive;
    }
}
