package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Exceptions.WrongItemIdException;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;

import java.util.ArrayList;

public class CheckOutManager {
    private Storage storage;

    public CheckOutManager(Storage storage) {
        this.storage = storage;
    }

    public boolean performCheckOut(UserAccount user, int movieId) throws WrongItemIdException, Exception {
        ItemLister movieLister = new ItemLister(storage, "movie");
        ArrayList<Movie> movieList = (ArrayList<Movie>)(Object) movieLister.getAvailableItemsListOfType();

        for (Movie movie : movieList) {
            boolean movieIdMatch = movieId == movie.getItemId();
            if (movieIdMatch) {
                CheckOut checkOut = new CheckOut(user, movie);
                storage.addCheckout(checkOut);
                return true;
            }
        }
        throw new WrongItemIdException("That movie is not available");
    }


}
