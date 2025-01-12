package com.jwt.auth.jwt_auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.jwt_auth.entity.User;
import com.jwt.auth.jwt_auth.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

     private final UserService userService;

  

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok((User) authentication.getPrincipal());
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
      

        return ResponseEntity.ok(userService.allUsers());
    }
    

}
