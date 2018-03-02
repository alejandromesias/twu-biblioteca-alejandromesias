package com.twu.biblioteca;

public class SingleBook {
    String name;
    String author;
    int year;

    public SingleBook(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
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
