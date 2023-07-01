package com.spring_boot_registration.service;

import com.spring_boot_registration.dto.UserRegistrationDto;
import com.spring_boot_registration.model.Role;
import com.spring_boot_registration.model.User;
import com.spring_boot_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public User saveUser(UserRegistrationDto registration) {
       User user = new User(registration.getFirstName(),
               registration.getLastName(),
              encoder.encode(registration.getPassword()), registration.getEmail(),
               Arrays.asList(new Role("ROLE_USER")) );
       return  userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw  new UsernameNotFoundException("User not found");
        }
         return new  org.springframework.security.core.userdetails.User(user.getEmail(),
                 user.getPassword(), mapRoleToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<Role> roles) {
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());

    }
}
