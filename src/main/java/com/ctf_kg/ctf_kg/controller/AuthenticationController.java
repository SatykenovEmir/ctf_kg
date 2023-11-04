package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.RegisterRequest;
import com.ctf_kg.ctf_kg.service.AuthenticationService;
import com.ctf_kg.ctf_kg.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    private final AuthenticationService service;

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> jobSeekerRegister(@RequestBody RegisterRequest request) {
        return service.playerRegister(request);
    }
    @GetMapping("/simpleGet")
    public String getall(){
        return "hkahljcksvn,";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
