package secureapi.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import secureapi.dto.*;
import secureapi.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public String register(
            @Valid
            @RequestBody
            RegisterRequest request
    ) {

        return service.register(request);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody
            LoginRequest request
    ) {

        return service.login(request);
    }
}