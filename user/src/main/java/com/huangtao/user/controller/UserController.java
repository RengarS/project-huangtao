package com.huangtao.user.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return new User(1, "aries");
    }
}

@Data
class User {
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
}
