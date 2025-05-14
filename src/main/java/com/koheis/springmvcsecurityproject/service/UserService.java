package com.koheis.springmvcsecurityproject.service;

import com.koheis.springmvcsecurityproject.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName (String userName);
}
