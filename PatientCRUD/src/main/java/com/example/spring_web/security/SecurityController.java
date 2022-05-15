package com.example.spring_web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    /*@GetMapping("error")
    public String accessDenied(){
        return "error";
    }*/
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
}
