package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private String menuMessage;
    private Integer optionId;

    public Menu() {
        optionId = 1;
        this.menuMessage = "Main menu:\n" + optionId + " Books";
    }

    public String getMenuMessage() {
        return menuMessage;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void userInput() {
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            String input = new BufferedReader(reader).readLine();
            isValidInput(input);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public boolean isValidInput(String optionIdString) {
        if (optionId == Integer.parseInt(optionIdString)) {
            return true;
        }
        System.out.println("Invalid Option Input!");
        return false;
    }
}
