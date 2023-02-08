package edu.security.jpa.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    //LoginService loginService;
    @Test
    @DisplayName("로그인 테스트")
    void loadUserByUsername() {
        //given
        String username = "userB";

        //when
       // PrincipalDetails userDetails = loginService.loadUserByUsername(username);

        //then
       // assertThat(username).isEqualTo(userDetails.getUsername());
    }
}