package edu.security.jpa.controller;

import edu.security.jpa.dto.JoinUserRequestDto;
import edu.security.jpa.dto.UserLoginRequestDto;
import edu.security.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homePage() {
        return "HOMEPAGE";
    }
    @GetMapping("/user")
    public String user() {
        return "user";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto);
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinUserRequestDto joinUserRequestDto) {

        String encodePassword = passwordEncoder.encode(joinUserRequestDto.getPassword());
        joinUserRequestDto.setPassword(encodePassword);

        userService.save(joinUserRequestDto);
        return "redirect:/login";
    }

}
