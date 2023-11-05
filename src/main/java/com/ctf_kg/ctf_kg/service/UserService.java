package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.entities.User;

public interface UserService {
    User getUsernameFromToken(String token);
}
