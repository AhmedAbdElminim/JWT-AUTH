package com.jwt.auth.jwt_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.auth.jwt_auth.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

        private final UserRepo userRepo;
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //This method tells Spring Security how to get the user details when they try to log in.
    @Bean
    UserDetailsService userDetailsService(){

        return userName -> userRepo.findByEmail(userName).orElseThrow(()->new UsernameNotFoundException("The User Not Found"));
    }


    //This AuthenticationManager bean Responsible for verifying the validity of login data (such as username and password).
    //It is later used in different places in the application to manage the user verification process.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{

        return config.getAuthenticationManager();
    }

    //DaoAuthenticationProvider is used to authenticate the user using a database (Data Access Object - DAO).
    //AuthenticationProvider is the intermediary between AuthenticationManager and user data. It implements the logic to validate username and password.
    @Bean
    public AuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


}
