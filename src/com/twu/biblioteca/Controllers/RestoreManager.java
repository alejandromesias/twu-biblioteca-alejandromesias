package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Depot;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;

import java.util.ArrayList;

public class RestoreManager {
    private Depot depot;

    public RestoreManager(Depot depot) {
        this.depot = depot;
    }

    public boolean performRestore(UserAccount aUser, Movie aMovie){
        depot.setCheckOutsList(new ArrayList<CheckOut>());
        return true;
    }
}
