package com.kunfeng2002.springsecurity.data;

import com.kunfeng2002.springsecurity.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AccountUser {
    private List<User> users = new ArrayList<>(
            List.of(
                    new User(1, "admin", "admin", "admin"),
                    new User(2, "abc", "123", "user"),
                    new User(3, "zxc", "456", "user")
            ));
    public List<User> getUsers() {
        return users;
    }
}
