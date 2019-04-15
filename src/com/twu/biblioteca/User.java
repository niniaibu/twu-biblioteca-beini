package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private boolean loginState;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        if (isValidLibraryNumber(libraryNumber)) {
            this.libraryNumber = libraryNumber;
            this.password = password;
            this.loginState = false;
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
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

    public void displayMyInformation() {
        String info = "name: " + this.name + "|" + "email: " + this.email + "|" + "phone number: " + this.phoneNumber;
        System.out.println(info);
    }
}
