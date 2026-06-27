package com.dev.Efoot.controller;

import com.dev.Efoot.controller.request.LoginRequest;
import com.dev.Efoot.controller.response.LoginResponse;
import com.dev.Efoot.service.FindUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final FindUserService findUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return findUserService.login(request);
    }
}
