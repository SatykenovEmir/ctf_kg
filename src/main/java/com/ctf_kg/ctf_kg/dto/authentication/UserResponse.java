package com.ctf_kg.ctf_kg.dto.authentication;

import com.ctf_kg.ctf_kg.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String email;
    private Role role;
    private boolean isOnline;
}
