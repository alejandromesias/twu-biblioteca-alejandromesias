package com.twu.biblioteca.Types;

public class Movie implements Item{
    private int movieId;
    private String name;
    private String director;
    private int year;
    private int rating;

    public Movie(int movieId, String name,
                 String director, int year,
                 int rating) {
        this.movieId = movieId;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public Movie(int movieId, String name,
                 String director, int year) {
        this(
                movieId,
                name,
                director,
                year,
                0
        );
    }

    public int getItemId() {
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

    @Override
    public boolean equals(Object obj) {

        Movie movie = (Movie) obj;
        if (movie.getItemId() == this.getItemId() &&
                movie.getName().equals(this.getName()) &&
                movie.getDirector().equals(this.getDirector()) &&
                movie.getYear() == (this.getYear())
                ) {
            return true;
        } else {
            return super.equals(obj);
        }
    }

    public String getHeaders(){
        String fiveColumnsFormat = "%-5s%-15s%-15s%-5s%-10s%n";
        return String.format(fiveColumnsFormat, "ID", "Movie Name", "Director", "Year", "Rating");
    }

    @Override
    public String toString() {
        String fiveColumnsFormat = "%-5s%-15s%-15s%-5s%-10s%n";
        return String.format(
                fiveColumnsFormat,
                getItemId(),
                getName(),
                getDirector(),
                getYear(),
                validateRatingToPrint(getRating()));
    }

    private String validateRatingToPrint(int rating) {
        if (rating > 0 && rating <= 10) {
            return Integer.toString(rating);
        }
        return "unrated";
    }
}
