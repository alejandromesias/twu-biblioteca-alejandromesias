package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewBookLister {

    public void display(){
        BookLister bookLister = new BookLister();
        ArrayList<Book> booksList;

        booksList = bookLister.getAvailableBooks();

        String fourColumnsFormat = "%-5s%-15s%-15s%-5s%n";
        System.out.format(fourColumnsFormat,"ID","Book Name","Author","Year");

        for (Book book : booksList) {
            System.out.format(fourColumnsFormat,
                    book.getBookId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getYear());
        }

    }
}