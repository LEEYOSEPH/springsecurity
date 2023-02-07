package edu.security.jpa.dto;

import edu.security.jpa.entity.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class JoinUserRequestDto {


    private String username;
    private String password;
    private String email;
    private String hobby;
    private String role;

    @Builder
    public JoinUserRequestDto(String username, String password, String email, String hobby,String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.hobby = hobby;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .hobby(hobby)
                .role(role)
                .build();
    }
}
