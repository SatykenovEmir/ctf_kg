package com.ctf_kg.ctf_kg.dto.smi;


import com.ctf_kg.ctf_kg.entities.User;
import com.ctf_kg.ctf_kg.mapper.smi.SmiMapper;
import com.ctf_kg.ctf_kg.mapper.smi.SmiMapperImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmiRequest {
    private String firstname;
    private String lastname;
}
