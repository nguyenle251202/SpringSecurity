package com.kunfeng2002.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable()).
                authorizeHttpRequests(request -> request.anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults()).
                sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
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
//        return new InMemoryUserDetailsManager(user1);
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        List<UserDetails> userDetailsList = accountUser.getUsers().stream()
//                .map(user -> org.springframework.security.core.userdetails.User
//                        .withDefaultPasswordEncoder()
//                        .username(user.getUsername())
//                        .password(user.getPassword())
//                        .roles(user.getRoles())
//                        .build())
//                .collect(Collectors.toList());
//
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("admin")
//                .build();
//        return new InMemoryUserDetailsManager();
//    }
}
