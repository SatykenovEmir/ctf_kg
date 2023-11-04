package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.RegisterRequest;
import com.ctf_kg.ctf_kg.service.AuthenticationService;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationRequest;
import com.ctf_kg.ctf_kg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    private final AuthenticationService service;

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> jobSeekerRegister(@RequestBody RegisterRequest request) {
        return service.register(request);
    }
    @GetMapping("/simpleGet")
    public String getall(){
        return "hkahljcksvn,";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}

//server.port=8087
//spring_profiles_active=prod
//PROD_DB_HOST=roundhouse.proxy.rlwy.net
//PROD_DB_PORT=54399
//PROD_DB_NAME=railway
//PROD_DB_USERNAME=postgres
//PROD_DB_PASSWORD=F3FeFa-a-E2E3Fa5aBfaDbf5B5GCfebe
//
//spring.datasource.name=postgres
//spring.datasource.url=jdbc:postgresql://${PROD_DB_HOST}:${PROD_DB_PORT}/${PROD_DB_NAME}
//spring.datasource.username=${PROD_DB_USERNAME}
//spring.datasource.password=${PROD_DB_PASSWORD}
//spring.jpa.hibernate.ddl-auto=update
//spring.flyway.baseline-on-migrate=false
//spring.sql.init.mode=always
//spring.main.allow-bean-definition-overriding=true
