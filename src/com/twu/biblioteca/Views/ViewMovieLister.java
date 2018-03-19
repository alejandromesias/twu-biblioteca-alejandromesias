package com.twu.biblioteca.Views;

import com.twu.biblioteca.Controllers.ItemLister;
import com.twu.biblioteca.Storage;


public class ViewMovieLister implements Task {
    Storage storage;

    public ViewMovieLister(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        ItemLister movieLister = new ItemLister(storage, "movie");
        System.out.println(movieLister.getPrintableList());
    }
}
