package com.spring_boot_registration.controller;

import com.spring_boot_registration.dto.UserRegistrationDto;
import com.spring_boot_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegController {
    @Autowired
    private UserService userService;
    @GetMapping
    public  String showRegistrationForm(){
        return  "registration";
    }

    @ModelAttribute("user")
    public  UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

      @PostMapping()
    public String registerUser(@ModelAttribute("user")UserRegistrationDto registration){
        userService.saveUser(registration);
        return  "redirect:/registration?success";
    }

}
