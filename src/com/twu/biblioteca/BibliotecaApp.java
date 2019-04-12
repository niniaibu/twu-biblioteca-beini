package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        try {
            Library library = new Library();
            library.displayWelcomeMessage();

            while (!library.isQuit()) {
                library.getMenu().displayMenu();
                library.getMenu().judgeUserInput();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
