package com.twu.biblioteca.Views;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Controllers.MovieLister;

public class ViewMovieLister implements Task {
    Storage storage;

    public ViewMovieLister(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        MovieLister movieLister = new MovieLister(storage);
        System.out.println(movieLister.getMoviesList());
    }
}
