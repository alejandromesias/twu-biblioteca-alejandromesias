package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewBookLister {

    public static void display(){

        ArrayList<SingleBook> booksList;

        //booksList = BookLister.getAllBooks();
        booksList = BookLister.getAvailableBooks();

        String fourColumnsFormat = "%-5s%-15s%-15s%-5s%n";

        for (SingleBook book : booksList) {
            System.out.format(fourColumnsFormat,
                    book.getBookId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getYear());
        }

    }
}
