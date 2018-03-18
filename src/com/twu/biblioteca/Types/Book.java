package com.twu.biblioteca.Types;

public class Book implements Item {
    private int BookId;
    private String name;
    private String author;
    private int year;


    public Book(int bookId, String name,
                 String director, int year) {
        this.BookId = bookId;
        this.name = name;
        this.author = director;
        this.year = year;

    }

    public int getItemId() {
        return BookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }



    @Override
    public boolean equals(Object obj) {

        Book book = (Book) obj;
        if (book.getItemId() == this.getItemId() &&
                book.getName().equals(this.getName()) &&
                book.getAuthor().equals(this.getAuthor()) &&
                book.getYear() == (this.getYear())
                ) {
            return true;
        } else {
            return super.equals(obj);
        }
    }
}
