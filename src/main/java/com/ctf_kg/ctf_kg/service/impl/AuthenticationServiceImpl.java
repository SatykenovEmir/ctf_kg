package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.RegisterRequest;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationResponse;
import com.ctf_kg.ctf_kg.dto.authentication.UserResponse;
import com.ctf_kg.ctf_kg.entities.User;
import com.ctf_kg.ctf_kg.exception.BadCredentialsException;
import com.ctf_kg.ctf_kg.repositories.CitizenRepository;
import com.ctf_kg.ctf_kg.repositories.UserRepository;
import com.ctf_kg.ctf_kg.security.JwtTokenProvider;
import com.ctf_kg.ctf_kg.service.AuthenticationService;
import com.ctf_kg.ctf_kg.dto.authentication.AuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final CitizenRepository citizenRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;



    @Override
    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {

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
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Optional<User> optionalAuth = userRepository.findByEmail(request.getEmail());
        if (optionalAuth.isEmpty()) {
            throw new NotFoundException("User not found with email: " + request.getEmail());
        }

        User auth = optionalAuth.get();

        userRepository.save(auth);


        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()));
        } catch (AuthenticationException e) {
            // Обработка ошибки аутентификации, например, неверный email или пароль
            throw new org.springframework.security.authentication.BadCredentialsException("Authentication failed: " + e.getMessage() + request.getEmail());
        }

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new NotFoundException("User not found"));
        String token = jwtTokenProvider.createToken(user.getEmail(), userRepository.findByEmail(user.getEmail()).get().getRole());
//        Optional<UserMessageInfo> userMessageInfo = userMessageInfoRepository.findByEmail(user.getEmail());
//        List<Message> messages = messageRepository.findAllBySender(user.getEmail());

// Obtain WebSocket session for the authenticated user

        return AuthenticationResponse.builder()
                .user(convertToresponse(user))
                .accessToken(token)
                .build();
    }

}
