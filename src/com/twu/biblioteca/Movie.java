package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie() {
    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void displayMovie() {
        String displayMovie = this.name + "|" + this.year + "|" + this.director + "|" + this.rating;
        System.out.println(displayMovie);
    }
}
