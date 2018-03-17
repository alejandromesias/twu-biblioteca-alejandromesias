package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutManager {
    private Depot depot;

    public CheckOutManager(Depot depot) {
        this.depot = depot;
    }

    public void performCheckOut(UserAccount user, int movieId) throws Exception {
        ArrayList<Movie> movieList = depot.getMoviesList();

        for (Movie movie : movieList) {
            boolean movieIdMatch = movieId == movie.getMovieId();
            if(movieIdMatch){
                CheckOut checkOut = new CheckOut(user,movie);
                depot.addCheckout(checkOut);
            }else{
                throw new Exception("That movie is not available");
            }
        }
    }

}
