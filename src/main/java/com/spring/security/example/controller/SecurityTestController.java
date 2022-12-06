package com.spring.security.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityTestController {

    @GetMapping
    public String getPublic(){
        return "This is a public endpoint.";
    }
    @GetMapping("/private")
    public String getPrivate(){
        return "This is a private endpoint.";
    }
}
