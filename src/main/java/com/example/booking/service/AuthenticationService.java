package com.example.booking.service;

import com.example.booking.entity.User;
import com.example.booking.exceptionHandling.UserNotFoundException;
import com.example.booking.interfaces.GenericCrudService;
import com.example.booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService{
  final UserRepository userRepository;

    public User authenticate(String username,String password) throws UserNotFoundException {
        boolean validate = userRepository.existsByUsernameAndPassword(username, password);
        if(validate){
            Optional<User> byUsername = userRepository.findByUsername(username);
            return byUsername.get();
        }
        else {
            throw new UserNotFoundException(username);
        }
    }

}
