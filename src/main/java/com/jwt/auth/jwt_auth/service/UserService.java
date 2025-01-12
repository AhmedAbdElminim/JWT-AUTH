package com.jwt.auth.jwt_auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jwt.auth.jwt_auth.entity.User;
import com.jwt.auth.jwt_auth.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

   

    public List<User> allUsers() {
        

        return userRepo.findAll();
    }
}