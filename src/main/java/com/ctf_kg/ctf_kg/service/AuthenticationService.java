package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.RegisterRequest;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> playerRegister(RegisterRequest request);


    ResponseEntity<AuthenticationResponse> adminRegister(RegisterRequest request);

    Object authenticate(RegisterRequest request);
}
