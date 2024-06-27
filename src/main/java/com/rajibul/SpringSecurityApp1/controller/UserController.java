package com.rajibul.SpringSecurityApp1.controller;

import com.rajibul.SpringSecurityApp1.models.UserInfo;
import com.rajibul.SpringSecurityApp1.service.UserInfoUserDetalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserInfoUserDetalsService userService;
    @PostMapping("/new")
    public String register(@RequestBody UserInfo user){
        return userService.register(user);
    }
}
