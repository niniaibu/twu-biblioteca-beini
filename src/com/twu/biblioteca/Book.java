package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publication;
    private boolean isCheckout;
    private boolean isReturn;

    public Book() {

    }

    public Book(String name, String author, int publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.isCheckout = false;
        this.isReturn = true;
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

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }
}
