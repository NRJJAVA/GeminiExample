package com.nrjtechworld.gemini.controller;

import com.nrjtechworld.gemini.contract.UserRegistrationRequest;
import com.nrjtechworld.gemini.contract.UserRegistrationResponse;
import com.nrjtechworld.gemini.entity.User;
import com.nrjtechworld.gemini.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());


        User savedUser = userService.createUser(user);


        UserRegistrationResponse response = new UserRegistrationResponse(savedUser.getUserId(), "User registered successfully!");
        return ResponseEntity.ok(response);
    }
}

