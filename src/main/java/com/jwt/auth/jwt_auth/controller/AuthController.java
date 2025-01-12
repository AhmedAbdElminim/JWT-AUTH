package com.jwt.auth.jwt_auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody String entity) {
        
        
        return entity;
    }

    
    @PostMapping("/signup")
    public String signUp(@RequestBody String entity) {
     
        
        return entity;
    }
    
    

}
