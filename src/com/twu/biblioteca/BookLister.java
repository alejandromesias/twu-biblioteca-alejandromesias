package com.twu.biblioteca;

        import java.util.ArrayList;

public class BookLister {
    public static ArrayList<SingleBook> getAllBooks(){

        ArrayList<SingleBook> allBooks = BibliotecaStorage.getBookCollection();
        if(allBooks.isEmpty()){
            BibliotecaStorage.initialize();
        }

        allBooks = BibliotecaStorage.getBookCollection();
        return allBooks;
    }

    public static ArrayList<SingleBook> getAvailableBooks() {

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
