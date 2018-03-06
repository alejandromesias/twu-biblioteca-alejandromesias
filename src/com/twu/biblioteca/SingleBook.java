package com.twu.biblioteca;

public class SingleBook {
    private int bookId;
    private String name;
    private String author;
    private int year;

    public SingleBook(int bookId, String name, String author, int year) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getBookId(){
        return this.bookId;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }


}
