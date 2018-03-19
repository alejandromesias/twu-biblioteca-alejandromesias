package com.twu.biblioteca.Controllers;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Item;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;

import java.util.ArrayList;

public class CheckOutManager {
    private Storage storage;
    private String itemType;

    public CheckOutManager(Storage storage, String itemType) {
        this.storage = storage;
        this.itemType = itemType;
    }

    public boolean performCheckOut(UserAccount user, int itemId) throws WrongItemIdException, Exception {
        ItemLister itemLister = new ItemLister(storage, itemType);
        ArrayList<Item> movieList = itemLister.getAvailableItemsListOfType();

        for (Item movie : movieList) {
            boolean movieIdMatch = itemId == movie.getItemId();
            if (movieIdMatch) {
                CheckOut checkOut = new CheckOut(user, movie);
                storage.addCheckout(checkOut);
                return true;
            }
        }
        throw new WrongItemIdException("That item is not available");
    }


}
