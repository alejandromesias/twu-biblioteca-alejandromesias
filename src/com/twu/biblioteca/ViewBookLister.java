package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewBookLister {

    public static void display(){

        ArrayList<SingleBook> booksList;

        booksList = BookLister.getAllBooks();

        for (SingleBook book : booksList) {
            System.out.println(book.getName());
        }

    }
}
