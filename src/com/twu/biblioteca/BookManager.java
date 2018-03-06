package com.twu.biblioteca;

import java.util.ArrayList;

public class BookManager {

    public static boolean lend(int requestedBookId, String personName){
        ArrayList<SingleBook> allBooks = BookLister.getAllBooks();

        for (SingleBook book : allBooks){
            if (book.getBookId() == requestedBookId) {
                SingleBook foundBook = book;

                foundBook.setCheckedOutByPerson(personName);
                foundBook.setIsCheckedOut(true);
                return foundBook.getIsCheckedOut();
            }
        }

        return false;
    }
}
