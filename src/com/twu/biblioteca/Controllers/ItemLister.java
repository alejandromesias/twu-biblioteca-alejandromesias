package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Item;
import com.twu.biblioteca.Types.Movie;

import java.util.ArrayList;

public class ItemLister {
    private Storage storage;

    public ItemLister(Storage storage) {
        this.storage = storage;
    }

    public String getPrintableList(String itemType){
        String printableList;
        ArrayList<Item> itemsList;

        try {
            itemsList = storage.geItemsList(itemType);
            String header = itemsList.get(0).getHeaders();
            String body = "";

            for (Item item : itemsList) {
                body = body + item.toString();
            }
            printableList = header + body;
        }catch(Exception exception){
            printableList = exception.getMessage();
        }

        return printableList;
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
