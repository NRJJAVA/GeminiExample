package com.nrjtechworld.gemini.service;

import com.nrjtechworld.gemini.config.EncoderConfig;
import com.nrjtechworld.gemini.entity.CustomUserDetails;
import com.nrjtechworld.gemini.entity.User;
import com.nrjtechworld.gemini.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);


        return new CustomUserDetails(user);
    }
}