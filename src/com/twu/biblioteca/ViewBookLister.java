package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewBookLister {

    public static void display(){

        ArrayList<SingleBook> booksList;

        booksList = BookLister.getAllBooks();

        String threeColumsFormat = "%-15s%-15s%-5s%n";

        for (SingleBook book : booksList) {
            System.out.format(threeColumsFormat, book.getName(), book.getAuthor(), book.getYear());
        }

    }
}
