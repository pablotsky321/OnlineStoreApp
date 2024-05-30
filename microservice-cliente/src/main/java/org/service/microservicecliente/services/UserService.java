package org.service.microservicecliente.services;

import org.service.microservicecliente.entities.ROLE;
import org.service.microservicecliente.entities.UserEntity;
import org.service.microservicecliente.repositories.UserRepository;
import org.service.microservicecliente.responses_requests.RegisterResponse;
import org.service.microservicecliente.responses_requests.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public RegisterResponse registerCliente(UserEntity cliente){
        if(userRepository.findByUsername(cliente.getUsername()).isPresent()){
            return new RegisterResponse("El cliente ya existe",null);
        }else{
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(ROLE.CLIENT.name()));
            cliente.setGrantedAuthorities(authorities);
            cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
            cliente.setRole(ROLE.CLIENT);
            UserEntity userSaved = userRepository.save(cliente);
            return new RegisterResponse("Usuario registrado",userSaved);
        }
    }

    public UserResponse findUserByid(String id){
        Optional<UserEntity> userFind = userRepository.findById(id);
        if(userFind.isEmpty()){
            return null;
        }else{
            return UserResponse
                    .builder()
                    .id(userFind.get().getId())
                    .nombres(userFind.get().getNombres())
                    .apellidos(userFind.get().getApellidos())
                    .username(userFind.get().getUsername())
                    .build();
        }
    }

}
