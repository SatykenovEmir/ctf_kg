package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.smi.SmiRequest;
import com.ctf_kg.ctf_kg.dto.smi.SmiResponse;
import com.ctf_kg.ctf_kg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private final UserService userService;

    @PostMapping("/smi_profile")
    public SmiResponse profile(@RequestHeader(name = "Authorization") String token,
                               @RequestBody SmiRequest smiRequest){
        return userService.smiProfile(token,smiRequest);
    }
}
