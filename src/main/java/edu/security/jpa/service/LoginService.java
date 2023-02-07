package edu.security.jpa.service;

import edu.security.jpa.config.auth.PrincipalDetails;
import edu.security.jpa.entity.User;
import edu.security.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티 설정에서 loginProcessingUrl("/login");
    // /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user != null) {
            System.out.println("UserService.loadUserByUsername : " + username);
            return new PrincipalDetails(user);
        }
        return null;
    }
}
