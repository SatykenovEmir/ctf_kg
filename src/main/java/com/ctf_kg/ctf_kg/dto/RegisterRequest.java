package com.ctf_kg.ctf_kg.dto;


import com.ctf_kg.ctf_kg.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private Role role;
}
