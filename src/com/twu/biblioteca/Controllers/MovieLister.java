package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Depot;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;

import java.util.ArrayList;

public class MovieLister {
    private Depot depot;

    public MovieLister(Depot depot) {
        this.depot = depot;
    }

    public String getMoviesList(){
        ArrayList<Movie> MoviesList = getAvailableMoviesList();

        String listAsText;

        String fourColumnsFormat = "%-5s%-15s%-15s%-5s%-10s%n";
        String header = String.format(fourColumnsFormat,"ID","Movie Name","Director","Year","Rating");
        String body = "";
        for (Movie movie : MoviesList) {
            body = body + String.format(
                    fourColumnsFormat,
                    movie.getMovieId(),
                    movie.getName(),
                    movie.getDirector(),
                    movie.getYear(),
                    validateRatingToPrint(movie.getRating()));
        }
        listAsText = header + body;

        return listAsText;
    }

    private String validateRatingToPrint(int rating){
        if(rating > 0 && rating <= 10){
            return Integer.toString(rating);
        }
        return "unrated";
    }


    public ArrayList<Movie> getAvailableMoviesList() {
        ArrayList<Movie> availableMovies = new ArrayList<>();
        ArrayList<Movie> allMovies = depot.getMoviesList();

        for (Movie movie : allMovies) {
            boolean isAvailable = !isInCheckOuts(movie);
            if(isAvailable){
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    private boolean isInCheckOuts(Movie movie){
        ArrayList<CheckOut> allCheckOuts = depot.getCheckOutsList();
        for(CheckOut checkOut: allCheckOuts){
            boolean movieMatch = movie.equals(checkOut.getLentMovie());
            if(movieMatch){
                return true;
            }
        }
        return false;
    }
}
