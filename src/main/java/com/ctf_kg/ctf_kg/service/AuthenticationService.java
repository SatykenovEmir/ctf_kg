package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.RegisterRequest;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationResponse;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> register(RegisterRequest request);


    ResponseEntity<AuthenticationResponse> adminRegister(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
