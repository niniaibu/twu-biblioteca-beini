package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        library.displayWelcomeMessage();

        while (!library.getMenu().isQuit()) {
            library.getMenu().displayMenu();
            System.out.print("Please input menu Id: ");
            library.getMenu().judgeUserInput();
        }
    }
}
