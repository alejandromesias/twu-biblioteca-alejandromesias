package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLister {
    private Depot depot;

    public MovieLister(Depot depot) {
        this.depot = depot;
    }

    public String getMoviesList(){
        ArrayList<Movie> MoviesList = depot.getMoviesList();

        String table = "testString";

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
                    movie.getRating());
        }
        table = header + body;

        return table;
    }

}
