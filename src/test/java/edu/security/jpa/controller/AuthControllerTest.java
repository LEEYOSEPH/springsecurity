package edu.security.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.security.jpa.JpaApplication;
import edu.security.jpa.config.JwtSecurityConfig;
import edu.security.jpa.config.SecurityConfig;
import edu.security.jpa.dto.UserLoginRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(controllers = JpaApplication.class,
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = SecurityConfig.class
                ),
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = JwtSecurityConfig.class
                )
               }
)
class AuthControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 구현 테스트")

    void signup() throws Exception {
        //given
        String content = objectMapper.writeValueAsString (new UserLoginRequestDto("testA","aaaa"));
        //when
        MvcResult mvcResult = mvc.perform(post("/signup")
                        .with(csrf())
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andReturn();
        //then
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("contentAsString = " + contentAsString);
    }

    @Test
    @DisplayName("로그인 구현 테스트")
    void login() throws Exception {
        //given
        String content = objectMapper.writeValueAsString (new UserLoginRequestDto("userA","aaaa"));
        //when
        MvcResult mvcResult = mvc.perform(post("/login")
                        .with(csrf())
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andReturn();
        //then
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("contentAsString = " + contentAsString);
    }
}