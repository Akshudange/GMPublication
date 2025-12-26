package com.example.GM.Publication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/public/**").permitAll()

                // ADMIN ACCESS
                .requestMatchers("/api/admin/**").hasRole("ADMIN")

                // AUTHOR ACCESS
                .requestMatchers("/api/author/**").hasAnyRole("AUTHOR", "ADMIN")

                // USER ACCESS
                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")

                .anyRequest().authenticated()
                )
                .sessionManagement(session ->
               session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
}
