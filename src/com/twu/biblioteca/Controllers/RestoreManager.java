package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;

import java.util.ArrayList;

public class RestoreManager {
    private Storage storage;

    public RestoreManager(Storage storage) {
        this.storage = storage;
    }

    public boolean performRestore(UserAccount aUser, int aMovieId) throws  WrongItemIdException{
        ArrayList<CheckOut> checkOutsList = storage.getCheckOutsList();
        for (CheckOut checkout : checkOutsList) {
            boolean userMatch = aUser.equals(checkout.getUserAccount());
            if(userMatch){
                boolean MovieIdMatch = aMovieId == checkout.getLentMovie().getMovieId();
                if(MovieIdMatch){
                    int checkOutIndex = checkOutsList.indexOf(checkout);
                    checkOutsList.remove(checkOutIndex);
                    return true;
                }

            }
        }
        throw new WrongItemIdException("That movie has not been lent");
    }
}
