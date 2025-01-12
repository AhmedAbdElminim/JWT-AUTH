package com.jwt.auth.jwt_auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.jwt_auth.dto.LoginUserDto;
import com.jwt.auth.jwt_auth.dto.RegisterUserDto;
import com.jwt.auth.jwt_auth.entity.LoginResponse;
import com.jwt.auth.jwt_auth.entity.User;
import com.jwt.auth.jwt_auth.service.AuthenticationService;
import com.jwt.auth.jwt_auth.service.JwtService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

        private final JwtService jwtService;
    
        private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody RegisterUserDto registerUserDto) {
     

        return ResponseEntity.ok(authenticationService.signup(registerUserDto));
    }
    
    

}
