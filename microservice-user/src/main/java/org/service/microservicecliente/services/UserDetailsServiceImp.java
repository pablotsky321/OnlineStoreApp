package org.service.microservicecliente.services;

import org.service.microservicecliente.entities.UserEntity;
import org.service.microservicecliente.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userFind = userRepository.findByUsername(username);
        if(userFind.isEmpty()) {
            throw new UsernameNotFoundException(username+" not found");
        }else {
            return User
                    .builder()
                    .username(userFind.get().getUsername())
                    .password(userFind.get().getPassword())
                    .authorities(userFind.get().getGrantedAuthorities())
                    .roles(userFind.get().getRole().name())
                    .build();
        }
    }
}
