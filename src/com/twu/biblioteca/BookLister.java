package com.twu.biblioteca;

        import java.util.ArrayList;

public class BookLister {

    BibliotecaStorage storage = new BibliotecaStorage();

    public ArrayList<Book> getAllBooks(){

        ArrayList<Book> allBooks = storage.getBookCollection();
        if(allBooks.isEmpty()){
            storage.initialize();
        }

        allBooks = storage.getBookCollection();
        return allBooks;
    }

    public ArrayList<Book> getAvailableBooks() {

        ArrayList<Book> allBooksList = getAllBooks();
        ArrayList<Book> availableBooksList = new ArrayList<Book>();

        for ( Book book: allBooksList ) {
            if(!book.getIsCheckedOut()){
                availableBooksList.add(book);
            }
        }

        return availableBooksList;
    }
}
