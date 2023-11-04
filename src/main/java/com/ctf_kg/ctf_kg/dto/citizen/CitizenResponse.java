package com.ctf_kg.ctf_kg.dto.citizen;

import com.ctf_kg.ctf_kg.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitizenResponse
{

    private String firstname;
    private String lastname;
    private Role role;
    private String email;
}
