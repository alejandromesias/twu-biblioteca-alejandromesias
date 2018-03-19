package com.twu.biblioteca.Views;

import com.twu.biblioteca.Controllers.ItemLister;
import com.twu.biblioteca.Storage;

public class ViewBookLister implements Task {
    Storage storage;

    public ViewBookLister(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        ItemLister bookLister = new ItemLister(storage, "book");
        System.out.println(bookLister.getPrintableList());

    }
}
