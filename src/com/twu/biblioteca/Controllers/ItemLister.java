package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Storage;
import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Item;
import com.twu.biblioteca.Types.Movie;

import java.util.ArrayList;

public class ItemLister {
    private Storage storage;
    private String itemType;

    public ItemLister(Storage storage, String itemType) {
        this.storage = storage;
        this.itemType = itemType;
    }

    public String getPrintableList(){
        String printableList;
        ArrayList<Item> itemsList;

        try {
            itemsList = getAvailableItemsListOfType();
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

    public ArrayList<Item> getAvailableItemsListOfType() throws Exception {
        ArrayList<Item> availableItemsOfType = new ArrayList<>();
        ArrayList<Item> allItemsOfType = storage.geItemsList(itemType);

        for (Item item : allItemsOfType) {
            boolean isAvailable = !isInCheckOuts(item);
            if (isAvailable) {
                availableItemsOfType.add(item);
            }
        }
        return availableItemsOfType;
    }

    private boolean isInCheckOuts(Item item) {
        ArrayList<CheckOut> allCheckOuts = storage.getCheckOutsList();
        for (CheckOut checkOut : allCheckOuts) {
            boolean itemMatch = item.equals(checkOut.getLentMovie());
            if (itemMatch) {
                return true;
            }
        }
        return false;
    }
}
