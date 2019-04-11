package com.twu.biblioteca;

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

    public boolean isValidInput(String optionIdString) {
        if (optionId == Integer.parseInt(optionIdString)) {
            return true;
        }
        System.out.println("Invalid Option Input!");
        return false;
    }
}
