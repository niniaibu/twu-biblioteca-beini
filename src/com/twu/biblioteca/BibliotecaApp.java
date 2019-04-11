package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu();
        System.out.println(library.getWelcomeMessage());
        System.out.println(menu.getMenuMessage());
    }
}
