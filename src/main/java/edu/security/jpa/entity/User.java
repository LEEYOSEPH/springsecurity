package edu.security.jpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String hobby;
    private String role;

    @Builder
    public User(Long id, String username, String password, String email, String hobby, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.hobby = hobby;
        this.role = role;
    }
}
