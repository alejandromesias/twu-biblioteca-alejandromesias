package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaStorage {

    private static ArrayList<Book> bookCollection = new ArrayList<Book>();

    public void initialize(){
        ArrayList<Book> mockBooks = new ArrayList<Book>();
        Book book0 = new Book(2,"mockBook0", "author0", 2000);
        Book book1 = new Book(3,"mockBook1", "author1", 2001);
        Book book2 = new Book(4,"mockBook2", "author2", 2002);
        mockBooks.add(book0);
        mockBooks.add(book1);
        mockBooks.add(book2);

        bookCollection = mockBooks;
    }

    public ArrayList<Book> getBookCollection(){
        return bookCollection;
    }

    public void updateBook(Book alteredBook){
        for (Book book : bookCollection) {
            if(book.getBookId() == alteredBook.getBookId()){
                int foundIndex = bookCollection.indexOf(book);
                bookCollection.set(foundIndex,alteredBook);
            }
        }
    }
}
