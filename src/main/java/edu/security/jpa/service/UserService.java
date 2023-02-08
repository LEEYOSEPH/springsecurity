package edu.security.jpa.service;

import edu.security.jpa.config.jwt.JwtTokenProvider;
import edu.security.jpa.dto.JoinUserRequestDto;
import edu.security.jpa.dto.UserLoginRequestDto;
import edu.security.jpa.entity.User;
import edu.security.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public Long save(JoinUserRequestDto joinUserRequestDto) {
        User user = joinUserRequestDto.toEntity();
        user.encodePassword(passwordEncoder);
       return userRepository.save(joinUserRequestDto.toEntity()).getId();
    }

    public String login(UserLoginRequestDto loginRequestDto) {
        User user = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(() -> new IllegalArgumentException("아이디가 없습니다."));
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }
        return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
    }
}
