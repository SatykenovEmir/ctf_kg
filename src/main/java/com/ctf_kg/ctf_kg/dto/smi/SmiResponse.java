package com.ctf_kg.ctf_kg.dto.smi;


import com.ctf_kg.ctf_kg.dto.file.FileResponse;
import com.ctf_kg.ctf_kg.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmiResponse {
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private FileResponse fileResponse;

}
