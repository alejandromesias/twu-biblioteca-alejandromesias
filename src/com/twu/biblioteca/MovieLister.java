package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLister {
    private Depot depot;

    public MovieLister(Depot depot) {
        this.depot = depot;
    }

    public String getMoviesList(){
        ArrayList<Movie> MoviesList = depot.getMoviesList();

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
}
