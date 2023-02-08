package edu.security.jpa.dto;

import edu.security.jpa.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String username;

    public static UserResponseDto of(User user){
        return new UserResponseDto(user.getUsername());
    }
}
