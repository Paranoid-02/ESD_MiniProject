package com.example.miniproject.auth;

import com.example.miniproject.Repository.UserRepository;
import com.example.miniproject.dto.LoginRequest;
import com.example.miniproject.dto.SignupRequest;
import com.example.miniproject.mapper.SignupToUserMapper;
import com.example.miniproject.security.JwtTokenUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignupToUserMapper signupToUserMapper;


    @Transactional
    public String signup(@Valid SignupRequest user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(signupToUserMapper.toEntity(user));

        return jwtTokenUtil.generateToken(user.getUsername());
    }

    public String verify(LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtTokenUtil.generateToken(loginRequest.getUsername());
        }
        return "Fail";
    }
}
