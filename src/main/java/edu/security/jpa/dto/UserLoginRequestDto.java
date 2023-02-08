package edu.security.jpa.dto;

import lombok.Getter;

@Getter
public class UserLoginRequestDto {
    private String username;
    private String password;
}
