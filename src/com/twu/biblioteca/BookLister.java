package com.twu.biblioteca;

        import java.util.ArrayList;

public class BookLister {

    BibliotecaStorage storage = new BibliotecaStorage();

    public ArrayList<SingleBook> getAllBooks(){

        ArrayList<SingleBook> allBooks = storage.getBookCollection();
        if(allBooks.isEmpty()){
            storage.initialize();
        }

        allBooks = storage.getBookCollection();
        return allBooks;
    }

    public ArrayList<SingleBook> getAvailableBooks() {

        ArrayList<SingleBook> allBooksList = getAllBooks();
        ArrayList<SingleBook> availableBooksList = new ArrayList<SingleBook>();

        for ( SingleBook book: allBooksList ) {
            if(!book.getIsCheckedOut()){
                availableBooksList.add(book);
            }
        }

        return availableBooksList;
    }
}
