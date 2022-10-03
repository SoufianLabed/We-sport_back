package com.example.WeSport.controllers;

import com.example.WeSport.models.ERole;
import com.example.WeSport.models.Role;
import com.example.WeSport.models.User;
import com.example.WeSport.payload.request.LoginRequest;
import com.example.WeSport.payload.request.SignupRequest;
import com.example.WeSport.payload.response.JwtResponse;
import com.example.WeSport.payload.response.MessageResponse;
import com.example.WeSport.repository.RoleRepository;
import com.example.WeSport.repository.UserRepository;
import com.example.WeSport.security.jwt.JwtUtils;
import com.example.WeSport.security.services.UserDetailsImpl;
import com.example.WeSport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.authenticateUser(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return ResponseEntity.ok().body(userService.registerUser(signUpRequest));
    }
}

