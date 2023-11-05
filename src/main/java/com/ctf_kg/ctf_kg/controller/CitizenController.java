package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.chatApi.OpenAIApiService;
import com.ctf_kg.ctf_kg.dto.citizen.CitizenResponse;
import com.ctf_kg.ctf_kg.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class CitizenController {

    private final CitizenService citizenService;
    private final OpenAIApiService openAIApiService;

    @GetMapping("/updateProfile")
    public List<CitizenResponse> getAllCitizen(){
        return citizenService.getAll();
    }

    @GetMapping("/openAI")
    public String getText(@RequestParam(required = false) String text){
        return openAIApiService.getResponse(text);
    }
}
