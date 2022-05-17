package com.example.springpractice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    String login(){
        return "/login";
    }

    @PostMapping("/registration")
    String registration(){
        return "registration";
    }
}
