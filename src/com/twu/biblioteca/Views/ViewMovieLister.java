package com.twu.biblioteca.Views;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.twu.biblioteca.Controllers.ItemLister;
import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Controllers.MovieLister;
import com.twu.biblioteca.Types.Item;

public class ViewMovieLister implements Task {
    Storage storage;

    public ViewMovieLister(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        ItemLister movieLister = new ItemLister(storage, "movie");
        System.out.println(movieLister.getPrintableList());
        //MovieLister movieLister = new MovieLister(storage);
        //System.out.println(movieLister.getMoviesList());
    }
}
