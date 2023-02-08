package edu.security.jpa.dto;

import edu.security.jpa.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class JoinUserRequestDto {


    private String username;
    private String password;
    private String email;
    private String hobby;
    private List<String> roles = new ArrayList<>();

    @Builder
    public JoinUserRequestDto(String username, String password, String email, String hobby) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.hobby = hobby;
        this.roles = Collections.singletonList("ROLE_USER");
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .hobby(hobby)
                .roles(roles)
                .build();
    }
}
