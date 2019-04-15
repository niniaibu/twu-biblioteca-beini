package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isCheckout;

    public Movie() {
    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        isCheckout = false;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public void displayMovie() {
        String displayMovie = this.name + "|" + this.year + "|" + this.director + "|" + this.rating;
        System.out.println(displayMovie);
    }

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }
}
