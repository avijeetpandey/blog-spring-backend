package com.blog.blogspringbackend.security;

import com.blog.blogspringbackend.exceptions.ResourceWithFieldNotFoundException;
import com.blog.blogspringbackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findByEmail(username)
                .orElseThrow(() -> new ResourceWithFieldNotFoundException("User", "email", username));
    }
}
