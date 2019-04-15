package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> options;
    private boolean quit;
    private BookMenu bookMenu;
    private MovieMenu movieMenu;
    private UserMenu userMenu;
    private User currentUser;

    public Menu() {
        this.quit = false;
        this.options = new ArrayList<>();
        addOption();
        this.bookMenu = new BookMenu();
        this.movieMenu = new MovieMenu();
        this.userMenu = new UserMenu();
    }

    public void addOption() {
        options.add(new Option(-1, "Quit"));
        options.add(new Option(1, "List of books"));
        options.add(new Option(2, "Checkout out a book"));
        options.add(new Option(3, "Return a book"));
        options.add(new Option(4, "List of movies"));
        options.add(new Option(5, "Checkout out a movie"));
        options.add(new Option(6, "Login"));
        options.add(new Option(7, "View books checkout"));
        options.add(new Option(8, "View my information"));
    }

    public void judgeUserInput() {
        try {
            System.out.print("Please input menu Id: ");
            String userMenuInput = getUserInput();
            if (!isValidInput(userMenuInput)) {
                return;
            }
            judgeUserMenuInput(userMenuInput);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public void judgeUserMenuInput(String menuUserInput) throws IOException {
        System.out.println("=====================");
        if (menuUserInput.equals("1")) {
            bookMenu.displayBooks();
        } else if (menuUserInput.equals("-1")) {
            this.quit = true;
        } else if (menuUserInput.equals("2")) {
            if (isValidCurrentUser()) {
                System.out.println("Please input checkout book name: ");
                String userBookInput = getUserInput();
                bookMenu.checkoutBook(userBookInput, currentUser);
            }
        } else if (menuUserInput.equals("3")) {
            if (isValidCurrentUser()) {
                System.out.println("Please input return book name: ");
                String userBookInput = getUserInput();
                bookMenu.returnBook(userBookInput, currentUser);
            }
        } else if (menuUserInput.equals("4")) {
            movieMenu.displayMovieMenu();
        } else if (menuUserInput.equals("5")) {
            System.out.println("Please input checkout movie name: ");
            String userMovieInput = getUserInput();
            movieMenu.checkoutMovie(userMovieInput);
        } else if (menuUserInput.equals("6")) {
            System.out.println("please input your library number: ");
            String libraryNumber = getUserInput();
            System.out.println("please input your password: ");
            String password = getUserInput();
            getLoginUser(libraryNumber, password);
        } else if (menuUserInput.equals("7")) {
            bookMenu.viewCheckoutedBooks();
        } else if (menuUserInput.equals("8")) {
            if (isValidCurrentUser()) {
                currentUser.displayMyInformation();
            }
        }
    }

    private boolean isValidCurrentUser() {
        if (currentUser == null) {
            System.out.println("Please sign in first.");
            return false;
        }
        return true;
    }

    private void getLoginUser(String libraryNumber, String password) {
        User user = userMenu.userLogin(libraryNumber, password);
        if (user != null) {
            this.currentUser = user;
        }
    }

    private String getUserInput() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        return new BufferedReader(reader).readLine();
    }

    public boolean isValidInput(String userInputId) {
        for (Option option : options) {
            if (option.getOptionId() == Integer.parseInt(userInputId)) {
                return true;
            }
        }
        System.out.println("Please select a valid option!");
        return false;
    }


    public void displayMenu() {
        System.out.println("=========================");
        System.out.println("Main menu:");
        options.forEach(Option::displayOption);
    }

    public boolean isQuit() {
        return quit;
    }
}
