package com.dev.Efoot.service;

import com.dev.Efoot.controller.request.CreateUserRequest;
import com.dev.Efoot.controller.response.UserResponse;
import com.dev.Efoot.entity.Scope;
import com.dev.Efoot.entity.User;
import com.dev.Efoot.exception.ResourceAlreadyExistsException;
import com.dev.Efoot.mapper.UserMapper;
import com.dev.Efoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private final FindScopeService findScopeService;

    public UserResponse create(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists, email: " + request.getEmail());
        }

        List<Scope> scopes = request.getScopes().stream()
                .map(findScopeService::findById)
                .toList();

        User newUser = userMapper.toEntity(request);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setScopes(scopes);
        User user = userRepository.save(newUser);
        return userMapper.toResponse(user);
    }
}

