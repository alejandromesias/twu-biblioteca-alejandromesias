package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutManager {
    private Depot depot;

    public CheckOutManager(Depot depot) {
        this.depot = depot;
    }

    public boolean performCheckOut(UserAccount user, int movieId) throws WrongItemIdException{
        ArrayList<Movie> movieList = depot.getMoviesList();

        for (Movie movie : movieList) {
            boolean movieIdMatch = movieId == movie.getMovieId();
            if(movieIdMatch) {
                CheckOut checkOut = new CheckOut(user, movie);
                depot.addCheckout(checkOut);
                return true;
            }
        }
        throw new WrongItemIdException("That movie is not in inventory");
    }


}
