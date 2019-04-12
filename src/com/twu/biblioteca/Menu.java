package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> options;
    private BookMenu bookMenu;
    private boolean quit;

    public Menu() {
        this.quit = false;
        this.options = new ArrayList<>();
        addOption();
    }

    public void addOption() {
        options.add(new Option(1, "List of books"));
        options.add(new Option(-1, "quit"));
        options.add(new Option(2, "Checkout out a book"));
    }

    public void judgeUserInput() {
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            String input = new BufferedReader(reader).readLine();
            if (!isValidInput(input)) {
                return;
            }
            if (input.equals("1")) {
                this.bookMenu = new BookMenu();
                bookMenu.displayBooks();
            } else if (input.equals("-1")) {
                this.quit = true;
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
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
        System.out.println("Main menu:");
        options.forEach(Option::displayOption);
    }

    public boolean isQuit() {
        return quit;
    }
}
