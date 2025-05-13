package com.kunfeng2002.springsecurity.config;

import com.kunfeng2002.springsecurity.data.AccountUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AccountUser accountUser = new AccountUser();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(customizer -> customizer.disable());
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());

        return http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("admin")
//                .build();
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("user")
//                .build();
//        UserDetails user3 = User
//                .withDefaultPasswordEncoder()
//                .username("sonwibu")
//                .password("sonwibu")
//                .roles("guest")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }
    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetailsList = accountUser.getUsers().stream()
                .map(user -> org.springframework.security.core.userdetails.User
                        .withDefaultPasswordEncoder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRoles())
                        .build())
                .collect(Collectors.toList());

        return new InMemoryUserDetailsManager(userDetailsList);
    }
}
