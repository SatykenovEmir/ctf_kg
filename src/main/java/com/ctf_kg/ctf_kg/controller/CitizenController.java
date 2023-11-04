package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.citizen.CitizenResponse;
import com.ctf_kg.ctf_kg.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizen")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping("/updateProfile")
    public List<CitizenResponse> getAllCitizen(){
        return citizenService.getAll();
    }
}
