package com.turkcell.identity_service.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.turkcell.identity_service.dto.UserRegisterRequest;
import com.turkcell.identity_service.dto.UserRegisterResponse;
import com.turkcell.identity_service.entity.User;

public interface UserService extends UserDetailsService {
    UserRegisterResponse create(UserRegisterRequest userRegisterRequest);
}
