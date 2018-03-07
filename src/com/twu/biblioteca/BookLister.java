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
}
