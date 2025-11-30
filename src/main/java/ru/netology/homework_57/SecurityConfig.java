package ru.netology.homework_57;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                (requests) -> {
//                    requests.requestMatchers("/endpoint0").permitAll();
//                }
//        );
//
//        http.formLogin(Customizer.withDefaults());
//
//        return http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();

        var users = new ArrayList<UserDetails>();

        users.add(
                User.builder()
                        .username("reader")
                        .password(encoder.encode("nopasswd"))
                        .roles("READ")
                        .build()
        );

        users.add(
                User.builder()
                        .username("writer")
                        .password(encoder.encode("nopasswd"))
                        .roles("WRITE")
                        .build()
        );

        users.add(
                User.builder()
                        .username("deleter")
                        .password(encoder.encode("nopasswd"))
                        .roles("DELETE")
                        .build()
        );

        return new InMemoryUserDetailsManager(users);
    }
}
