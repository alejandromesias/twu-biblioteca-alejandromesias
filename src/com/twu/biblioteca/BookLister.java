package com.twu.biblioteca;

        import java.util.ArrayList;

public class BookLister {
    public static ArrayList<SingleBook> getAllBooks(){
        ArrayList<SingleBook> mockBooks = new ArrayList<SingleBook>();
        SingleBook book0 = new SingleBook("mockBook0", "author0", 2000);
        SingleBook book1 = new SingleBook("mockBook1", "author1", 2001);
        SingleBook book2 = new SingleBook("mockBook2", "author2", 2002);
        mockBooks.add(book0);
        mockBooks.add(book1);
        mockBooks.add(book2);

        ArrayList<SingleBook> allBooks = mockBooks;
        return allBooks;
    }
}
