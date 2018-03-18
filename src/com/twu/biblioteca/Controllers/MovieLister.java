package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Item;
import com.twu.biblioteca.Types.Movie;

import java.util.ArrayList;

public class MovieLister {
    private Storage storage;

    public MovieLister(Storage storage) {
        this.storage = storage;
    }

    public String getMoviesList() {
        ArrayList<Item> MoviesListOriginal = getAvailableMoviesList();
        ArrayList<Movie> MoviesList =(ArrayList<Movie>)(Object) MoviesListOriginal;

        String listAsText;

        String fourColumnsFormat = "%-5s%-15s%-15s%-5s%-10s%n";
        String header = String.format(fourColumnsFormat, "ID", "Movie Name", "Director", "Year", "Rating");
        String body = "";

        for (Movie movie : MoviesList) {
            body = body + String.format(
                    fourColumnsFormat,
                    movie.getItemId(),
                    movie.getName(),
                    movie.getDirector(),
                    movie.getYear(),
                    validateRatingToPrint(movie.getRating()));
        }
        listAsText = header + body;

        return listAsText;
    }

    private String validateRatingToPrint(int rating) {
        if (rating > 0 && rating <= 10) {
            return Integer.toString(rating);
        }
        return "unrated";
    }


    public ArrayList<Item> getAvailableMoviesList() {
        ArrayList<Item> availableMovies = new ArrayList<>();
        ArrayList<Item> allMovies = storage.getMoviesList();

        for (Item movie : allMovies) {
            boolean isAvailable = !isInCheckOuts(movie);
            if (isAvailable) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    private boolean isInCheckOuts(Item movie) {
        ArrayList<CheckOut> allCheckOuts = storage.getCheckOutsList();
        for (CheckOut checkOut : allCheckOuts) {
            boolean movieMatch = movie.equals(checkOut.getLentMovie());
            if (movieMatch) {
                return true;
            }
        }
        return false;
    }
}
