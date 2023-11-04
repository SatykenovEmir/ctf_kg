package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.RegisterRequest;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationResponse;
import com.ctf_kg.ctf_kg.dto.authentication.UserResponse;
import com.ctf_kg.ctf_kg.entities.User;
import com.ctf_kg.ctf_kg.enums.Role;
import com.ctf_kg.ctf_kg.exception.BadCredentialsException;
import com.ctf_kg.ctf_kg.repositories.PlayerRepository;
import com.ctf_kg.ctf_kg.repositories.UserRepository;
import com.ctf_kg.ctf_kg.security.JwtTokenProvider;
import com.ctf_kg.ctf_kg.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final PlayerRepository playerRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public ResponseEntity<AuthenticationResponse> playerRegister(RegisterRequest request) {

       // checkUsernameIsExist(request.getEmail());
//        String reg = "^A-Za-z0-9+_.-]+@(.+)$";
//        Pattern pattern = Pattern.compile(reg);
//        User user = new User();
//        Matcher matcher = pattern.matcher(request.getEmail());
//        if (!matcher.matches()){
//            throw new BadCredentialsException("the email is incorrect!");
//        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new BadCredentialsException("this email already exists");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        user.setRole(request.getRole());

        userRepository.save(user);

        return ResponseEntity.ok(convertAuthentication(user));
    }

    private AuthenticationResponse convertAuthentication(User user) {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setUser(convertToresponse(user));

        String token = jwtTokenProvider.createToken(user.getEmail(), userRepository.findByEmail(user.getEmail()).get().getRole());
        response.setAccessToken(token);
        return response;
    }

    private UserResponse convertToresponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        return userResponse;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> adminRegister(RegisterRequest request) {
        return null;
    }

    @Override
    public Object authenticate(RegisterRequest request) {
        return null;
    }
}
