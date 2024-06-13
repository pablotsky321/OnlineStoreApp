package org.service.microservicecliente.config;

import org.service.microservicecliente.services.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf->{
                    csrf.disable();
                })
                .cors(cors->{
                    cors.disable();
                })
                .authorizeHttpRequests(request->{
                    request.requestMatchers("/api/usuario/**").permitAll();
                })
                .userDetailsService(userDetailsServiceImp)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
