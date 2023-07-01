package com.spring_boot_registration.service;

import com.spring_boot_registration.dto.UserRegistrationDto;
import com.spring_boot_registration.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    User saveUser(UserRegistrationDto registration);
}
