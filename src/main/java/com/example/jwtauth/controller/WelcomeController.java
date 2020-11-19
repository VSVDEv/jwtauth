package com.example.jwtauth.controller;

import com.example.jwtauth.model.AuthRequest;
import com.example.jwtauth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final JwtUtil util;

    private final AuthenticationManager manager;

@Autowired
    public WelcomeController(JwtUtil util, AuthenticationManager manager) {
        this.util = util;
        this.manager = manager;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to VSVDev !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return util.generateToken(authRequest.getUserName());
    }
}
