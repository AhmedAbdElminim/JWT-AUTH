package com.jwt.auth.jwt_auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.auth.jwt_auth.dto.LoginUserDto;
import com.jwt.auth.jwt_auth.dto.RegisterUserDto;
import com.jwt.auth.jwt_auth.entity.User;
import com.jwt.auth.jwt_auth.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepo userRepo;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;


        public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepo.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepo.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
