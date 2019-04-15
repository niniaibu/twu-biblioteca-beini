package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MovieMenu {
    private List<Movie> movies;

    public MovieMenu() {
        this.movies = new ArrayList<>();
        addMovie();
    }

    public void addMovie() {
        this.movies.add(new Movie("Titanic", 1997, "James Cameron", 10));
        this.movies.add(new Movie("The Fast and the Furious", 2001, "Rob Cohen", 7));
        this.movies.add(new Movie("Avatar", 2009, "James Cameron", 9));
        this.movies.add(new Movie("The Wandering Earth", 2019, "Frant Gwo", 5));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void displayMovieMenu() {
        movies.forEach(Movie::displayMovie);
    }

    public void checkoutMovie(String movieName) {
        for (Movie movie : movies) {
            if (movieName.equals(movie.getName())) {
                movie.setCheckout(true);
                System.out.println("Thank you! Enjoy the movie");
                return;
            }
        }
        System.out.println("Sorry, that movie is not available");
    }
}

