package edu.security.jpa.config;

import edu.security.jpa.config.jwt.JwtAuthenticationFilter;
import edu.security.jpa.config.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
      /*  http.authorizeRequests()
                .mvcMatchers("/user").authenticated() // 인증만 되면 들어갈 수 있는 주소
                .mvcMatchers("/manager").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers("/admin").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login") // login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");*/
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션 사용 안함
                .and()
                .authorizeRequests()
                .mvcMatchers("/user").authenticated()
                .mvcMatchers("/manager").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/join", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                // JwtAuthenticationFilter를 먼저 적용
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();//default: bcrypt
    }
}
