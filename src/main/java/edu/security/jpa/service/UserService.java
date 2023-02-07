package edu.security.jpa.service;

import edu.security.jpa.dto.JoinUserRequestDto;
import edu.security.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long save(JoinUserRequestDto joinUserRequestDto) {
       return userRepository.save(joinUserRequestDto.toEntity()).getId();
    }
}
