package com.twu.biblioteca;

public class Movie {
    private int movieId;
    private String name;
    private String director;
    private int year;
    private int rating;

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public Movie(int movieId, String name, String director, int year, int rating) {
        this.movieId = movieId;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
