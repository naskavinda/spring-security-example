package com.spring.security.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SecurityTestController {

    @GetMapping
    public String getPublic(){
        return "This is a public endpoint.";
    }
    @GetMapping("/private")
    public String getPrivate(Authentication authentication){
        return "This is a private endpoint. " + getName(authentication);
    }

    private static String getName(Authentication authentication) {
        return Optional.of(authentication.getPrincipal())
                .filter(OAuth2User.class::isInstance)
                .map(OAuth2User.class::cast)
                .map(OAuth2User::getAttributes)
                .map(attribute -> attribute.get("name").toString())
                .orElse(authentication.getName());
    }
}
