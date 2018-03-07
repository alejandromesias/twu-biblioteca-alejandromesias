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
        ArrayList<SingleBook> availableBooksList = new ArrayList<SingleBook>();

        //TODO: replace hardcoded
        SingleBook book0 = new SingleBook(2,"mockBook0", "author0", 2000);
        SingleBook book2 = new SingleBook(4,"mockBook2", "author2", 2002);
        availableBooksList.add(book0);
        availableBooksList.add(book2);

        return availableBooksList;

    }
}
