package com.twu.biblioteca.Views;

import com.twu.biblioteca.Depot;
import com.twu.biblioteca.Controllers.MovieLister;

public class ViewMovieLister implements Task {
    Depot depot;

    public ViewMovieLister(Depot depot) {
        this.depot = depot;
    }

    @Override
    public void execute() {
        MovieLister movieLister = new MovieLister(depot);
        System.out.println(movieLister.getMoviesList());
    }
}
