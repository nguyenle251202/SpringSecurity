package com.kunfeng2002.springsecurity.control;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/hello-world")
    public String helloWorld(HttpServletRequest request) {
        return "Hello World!";
    }
}
