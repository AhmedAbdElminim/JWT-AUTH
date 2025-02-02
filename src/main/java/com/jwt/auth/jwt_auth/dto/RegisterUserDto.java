package com.jwt.auth.jwt_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String email;
    
    private String password;
    
    private String fullName;
}
