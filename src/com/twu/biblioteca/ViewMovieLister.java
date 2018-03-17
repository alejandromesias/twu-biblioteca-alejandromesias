package com.twu.biblioteca;

public class ViewMovieLister implements Task {

    @Override
    public void execute(Depot depot) {
        MovieLister movieLister = new MovieLister(depot);
        System.out.println(movieLister.getMoviesList());
    }
}
