package com.twu.biblioteca;

public class Library {
    private String welcomeMessage;
    private Menu menu;


    public Library() {
        this.welcomeMessage = "Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!";
        menu = new Menu();
    }

    public Menu getMenu() {
        return menu;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }
}
