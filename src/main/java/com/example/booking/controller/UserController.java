package com.example.booking.controller;

import com.example.booking.entity.User;
import com.example.booking.exceptionHandling.UserNotFoundException;
import com.example.booking.payload.UserDto;
import com.example.booking.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping
    public HttpEntity<User> authenticate(@RequestBody UserDto dto) throws UserNotFoundException {
        User authenticate = authenticationService.authenticate(dto.getPassword(), dto.getUsername());
        return ResponseEntity.ok().body(authenticate);
    }

}
