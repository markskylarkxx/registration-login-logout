package com.spring_boot_registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {

    @GetMapping("/login")
    public  String login() {
        return "login";
    }

    @GetMapping("")
    public  String homePage(){
        return "home";
    }
    @GetMapping("api/check")
    public String check(){
        return  "check";
    }

}
