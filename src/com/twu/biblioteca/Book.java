package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publication;

    public Book() {
    }

    public Book(String name, String author, int publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication() {
        return publication;
    }

    public String getDisplayMessage() {
        return this.name + "|" + this.author + "|" + this.publication;
    }

}
