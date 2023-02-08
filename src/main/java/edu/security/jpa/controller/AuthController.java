package edu.security.jpa.controller;

import edu.security.jpa.dto.TokenDto;
import edu.security.jpa.dto.UserLoginRequestDto;
import edu.security.jpa.dto.UserResponseDto;
import edu.security.jpa.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserLoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.signup(loginRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserLoginRequestDto loginRequestDto) {

        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
}
