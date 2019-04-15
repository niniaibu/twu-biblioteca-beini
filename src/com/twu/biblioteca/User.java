package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private boolean loginState;

    public User(String libraryNumber, String password) {
        if (isValidLibraryNumber(libraryNumber)) {
            this.libraryNumber = libraryNumber;
            this.password = password;
            this.loginState = false;
        } else {
            System.out.println("Invalid User for wrong library number");
        }
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    private boolean isValidLibraryNumber(String libraryNumber) {
        if (libraryNumber.contains("-")) {
            String[] strings = libraryNumber.split("-");
            return (strings[0].length() == 3 && strings[1].length() == 4);
        }
        return false;
    }

    public boolean isValidPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isLogin() {
        return loginState;
    }

    public boolean login(String libraryNumber, String password) {
        if (this.libraryNumber.equals(libraryNumber) && this.password.equals(password)) {
            this.loginState = true;
            return true;
        }
        return false;
    }
}
