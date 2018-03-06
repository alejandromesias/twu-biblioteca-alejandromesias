package com.twu.biblioteca;

public class SingleBook {
    private int bookId;
    private String name;
    private String author;
    private int year;

    private boolean isCheckedOut;
    private String checkedOutByPerson;

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


    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }


    public String getCheckedOutByPerson() {
        return checkedOutByPerson;
    }

    public void setCheckedOutByPerson(String checkedOutByPerson) {
        this.checkedOutByPerson = checkedOutByPerson;
    }
}
