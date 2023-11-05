package com.ctf_kg.ctf_kg.mapper.smi;

import com.ctf_kg.ctf_kg.dto.smi.SmiResponse;
import com.ctf_kg.ctf_kg.entities.User;

public interface SmiMapper {
    SmiResponse toDto(User save);
}
