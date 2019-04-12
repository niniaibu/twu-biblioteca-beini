package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.getWelcomeMessage());
        System.out.println(library.getMenu().getMenuMessage());
        System.out.print("Please input menu Id: ");
        library.getMenu().userInput();
    }
}
