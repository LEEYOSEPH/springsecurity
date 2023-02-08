package edu.security.jpa.repository;

import edu.security.jpa.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    @DisplayName("아이디로 데이터 호출")
    void findByUsername() {
    //given
        String username = "userb";
        userRepository.save(User.builder().username(username).build());

        //when
        //User user = userRepository.findByUsername(username);

        //then
       // Assertions.assertThat(username).isEqualTo(user.getUsername());


    }

}