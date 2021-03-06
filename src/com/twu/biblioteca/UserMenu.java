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
        users.add(new User("111-1111", "111111", "zhangsan", "11111111@qq.com", "11111111111"));
        users.add(new User("222-2222", "222222", "lisi", "222222222@qq.com", "22222222222"));
        users.add(new User("333-3333", "333333", "wangwu", "333333333@qq.com", "33333333333"));
        users.add(new User("444-4444", "444444", "beini", "4444444444@qq.com", "44444444444"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User userLogin(String libraryNumber, String password) {
        for (User user : users) {
            if (user.login(libraryNumber, password)) {
                System.out.println("Hi, " + user.getLibraryNumber() + " !");
                return user;
            }
        }
        System.out.println("Wrong, please input again");
        return null;
    }
}
