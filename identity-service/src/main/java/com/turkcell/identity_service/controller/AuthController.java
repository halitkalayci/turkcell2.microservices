package com.turkcell.identity_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.identity_service.dto.UserRegisterRequest;
import com.turkcell.identity_service.dto.UserRegisterResponse;
import com.turkcell.identity_service.service.UserService;

import io.github.halitkalayci.security.jwt.BaseJwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final BaseJwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody @Valid UserRegisterRequest user){
        return ResponseEntity.ok(userService.create(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(){
        // TODO: username ve password alınacak ve kontrol edilecek
        return ResponseEntity.ok(jwtService.generateToken("halit"));
    }
    
}
