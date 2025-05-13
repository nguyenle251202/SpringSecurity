package com.kunfeng2002.springsecurity.control;

import com.kunfeng2002.springsecurity.data.AccountUser;
import com.kunfeng2002.springsecurity.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControl {

    private final AccountUser accountUser = new AccountUser();

    @GetMapping("/account")
    public List<User> getAllUser() {
        return accountUser.getUsers();
    }

    @GetMapping("/csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/accounts")
    public User addAccount(@RequestBody User user) {
        accountUser.getUsers().add(user);
        return user;
    }
}
