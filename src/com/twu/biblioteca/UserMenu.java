package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {
    private List<User> users;

    public UserMenu() {
        this.users = new ArrayList<>();
        addUser();
    }

    public void addUser() {
        users.add(new User("111-1111", "111111"));
        users.add(new User("222-2222", "222222"));
        users.add(new User("333-3333", "333333"));
        users.add(new User("444-4444", "444444"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void userLogin(String libraryNumber, String password) {
        for (User user : users) {
            if (user.login(libraryNumber, password)) {
                System.out.println("Hi, " + user.getLibraryNumber() + " !");
                return;
            }
        }
        System.out.println("Wrong, please input again");
    }
}
