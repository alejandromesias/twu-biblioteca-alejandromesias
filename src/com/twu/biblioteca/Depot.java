package com.twu.biblioteca;

import com.twu.biblioteca.Types.CheckOut;
import com.twu.biblioteca.Types.Movie;
import com.twu.biblioteca.Types.UserAccount;

import java.util.ArrayList;

public class Depot {

    private ArrayList<UserAccount> usersList;
    private ArrayList<Movie> moviesList;
    private ArrayList<CheckOut> checkOutsList = new ArrayList<CheckOut>();

    public Depot() {
        this.usersList = buildUsers();
        this.moviesList = buildMovies();
    }

    public ArrayList<UserAccount> getUsersList() {
        return usersList;
    }

    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    public ArrayList<CheckOut> getCheckOutsList() {
        return checkOutsList;
    }

    public void setCheckOutsList(ArrayList<CheckOut> checkOutsList) {
        this.checkOutsList = checkOutsList;
    }

    public void addCheckout(CheckOut newCheckOut){
        checkOutsList.add(newCheckOut);
    }

    private ArrayList<UserAccount> buildUsers(){
        ArrayList<UserAccount> users = new ArrayList<UserAccount>();
        UserAccount user;
        user = new UserAccount(1112222,
                "Password0",
                "User0",
                "user0@email.com",
                "0999999999");
        users.add(user);
        user = new UserAccount(2223333,
                "Password1",
                "User1",
                "user1@email.com",
                "0888888888");
        users.add(user);
        user = new UserAccount(3334444,
                "Password2",
                "User2",
                "user2@email.com",
                "0777777777");
        users.add(user);

        return users;
    }

    private ArrayList<Movie> buildMovies(){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie;
        movie = new Movie(3,
                "theMovie0",
                "Director0",
                2010,
                10);
        movies.add(movie);
        movie = new Movie(4,
                "theMovie1",
                "Director1",
                2011,
                9);
        movies.add(movie);
        movie = new Movie(5,
                "theMovie2",
                "Director2",
                2012);
        movies.add(movie);

        return movies;
    }
}
