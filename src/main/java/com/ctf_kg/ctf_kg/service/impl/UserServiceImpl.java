package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.smi.SmiRequest;
import com.ctf_kg.ctf_kg.dto.smi.SmiResponse;
import com.ctf_kg.ctf_kg.entities.User;
import com.ctf_kg.ctf_kg.mapper.smi.SmiMapper;
import com.ctf_kg.ctf_kg.repositories.UserRepository;
import com.ctf_kg.ctf_kg.service.UserService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SmiMapper smiMapper;
    @Override
    public User getUsernameFromToken(String token) {

        String[] chunks = token.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return userRepository.findByEmail(String.valueOf(object.get("sub"))).orElseThrow(() -> new RuntimeException("user can be null"));
    }

    @Override
    public SmiResponse smiProfile(String token, SmiRequest smiRequest) {
        User user = getUsernameFromToken(token);
        user.setFirstname(smiRequest.getFirstname());
        user.setLastname(smiRequest.getLastname());
        return smiMapper.toDto(userRepository.save(user));
    }
}
