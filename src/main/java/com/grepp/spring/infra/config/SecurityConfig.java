package com.grepp.spring.infra.config;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Value("${remember-me.key}")
    private String rememberMeKey;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .build();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request,
                                                HttpServletResponse response, Authentication authentication)
                    throws IOException, ServletException {

                boolean isAdmin = authentication.getAuthorities()
                        .stream()
                        .anyMatch(authority ->
                                authority.getAuthority().equals("ROLE_ADMIN"));

                if (isAdmin) {
                    response.sendRedirect("/admin");
                    return;
                }

                response.sendRedirect("/");
            }
        };

    }

    // rememberme-debug
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // * : 1depth 아래 모든 경로
        // ** : 모든 depth 의 모든 경로
        // Security Config 에는 인증과 관련된 설정만 지정 (PermitAll or Authenticated)
        http
                .authorizeHttpRequests(
                        (requests) -> requests
                                .requestMatchers(GET, "/").permitAll()      // 메인 페이지 - 누구나 접근 가능
                                .requestMatchers(GET, "/member/signup").permitAll()
                                .requestMatchers(GET, "/member/signin").permitAll()
                                .requestMatchers(GET, "order/**").authenticated()
                                .requestMatchers(GET, "cartList/**").authenticated()
                                .requestMatchers(POST, "/member/signin", "/member/signup").permitAll()
                                .anyRequest().permitAll() //  나머지는 로그인 필요!
                )
                .formLogin((form) -> form
                        .loginPage("/member/signin")
                        .usernameParameter("userId")
                        .loginProcessingUrl("/member/signin")
                        .defaultSuccessUrl("/")
                        .successHandler(successHandler())
                        .permitAll()
                )
                .rememberMe(rememberMe -> rememberMe.key(rememberMeKey))
                .logout(LogoutConfigurer::permitAll);
//=======
//            .authorizeHttpRequests(
//                (requests) -> requests
//                    .requestMatchers(GET, "/member/signup").permitAll()
//                    .requestMatchers(GET, "/member/signin").permitAll()
//                    .requestMatchers(POST, "/member/signin", "/member/signup").permitAll()
//                    .requestMatchers(GET,"/cartList").authenticated()
//                    .requestMatchers(GET,"/order").authenticated()
//                    .anyRequest().permitAll() // 로그인 후 페이지 접근하려면 authenticated()로 변경해야 한다.
//            )
//            .formLogin((form) -> form
//                .loginPage("/member/signin")
//                .usernameParameter("userId")
//                .loginProcessingUrl("/member/signin")
//                .defaultSuccessUrl("/")
//                .successHandler(successHandler())
//                .permitAll()
//            )
//            .rememberMe(rememberMe -> rememberMe.key(rememberMeKey))
//            .logout(LogoutConfigurer::permitAll);
//>>>>>>> origin/lkh
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/assets/**", "/favicon.ico");
    }

}