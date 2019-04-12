package com.twu.biblioteca;

public class Option {
    private int optionId;
    private String menuMessage;

    public Option(int optionId, String menuMessage) {
        this.optionId = optionId;
        this.menuMessage = menuMessage;
    }

    public int getOptionId() {
        return optionId;
    }

    public String getMenuMessage() {
        return menuMessage;
    }

    public void displayOption() {
        System.out.println(optionId + " " + menuMessage);
    }
}
