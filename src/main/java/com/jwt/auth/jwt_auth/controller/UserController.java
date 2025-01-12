package com.jwt.auth.jwt_auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/users")
    public String getUsers(@RequestParam String param) {
        return new String();
    }
    @GetMapping("/user/me")
    public String getAuthUser(@RequestParam String param) {
        return new String();
    }
    

}
