package com.ws.user.controller;

import com.ws.user.pojo.User;
import com.ws.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;

    @Value("${test.name}")
    private String name;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id) {
        User user=us.queryById(id);
        System.out.println(name);
        return user;
    }
}
