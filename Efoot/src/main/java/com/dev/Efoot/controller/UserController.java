package com.dev.Efoot.controller;

import com.dev.Efoot.controller.request.CreateUserRequest;
import com.dev.Efoot.controller.response.UserResponse;
import com.dev.Efoot.service.CreateUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping
    public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
        return createUserService.create(request);
    }

}