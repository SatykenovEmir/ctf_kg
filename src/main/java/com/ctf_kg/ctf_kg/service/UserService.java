package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.smi.SmiRequest;
import com.ctf_kg.ctf_kg.dto.smi.SmiResponse;
import com.ctf_kg.ctf_kg.entities.User;

public interface UserService {
    User getUsernameFromToken(String token);

    SmiResponse smiProfile(String token, SmiRequest smiRequest);
}
