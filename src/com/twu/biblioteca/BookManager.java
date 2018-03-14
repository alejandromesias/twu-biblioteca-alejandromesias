package com.twu.biblioteca;

import java.util.ArrayList;

public class BookManager {

    public boolean lend(int requestedBookId, String personName){
        BookLister bookLister = new BookLister();
        ArrayList<SingleBook> allBooks = bookLister.getAllBooks();

        for (SingleBook book : allBooks){
            if (book.getBookId() == requestedBookId) {
                SingleBook foundBook = book;

                foundBook.setCheckedOutByPerson(personName);
                foundBook.setIsCheckedOut(true);
                BibliotecaStorage.updateBook(foundBook);
                return foundBook.getIsCheckedOut();
            }
        }

        return false;
    }

    public Boolean restore(int requestedBookId, String personName) {
        BookLister bookLister = new BookLister();
        ArrayList<SingleBook> allBooks = bookLister.getAllBooks();

        for (SingleBook book : allBooks){
            if (book.getCheckedOutByPerson() != null) {
                if (book.getBookId() == requestedBookId && book.getCheckedOutByPerson().equals(personName)) {
                    SingleBook foundBook = book;
                    foundBook.setCheckedOutByPerson(null);
                    foundBook.setIsCheckedOut(false);
                    BibliotecaStorage.updateBook(foundBook);
                    return !foundBook.getIsCheckedOut();
                }
            }
        }

        return false;
    }
}
