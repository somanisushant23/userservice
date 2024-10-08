package com.sushant.userservice.controllers;

import com.sushant.userservice.dtos.SignUpRequestDto;
import com.sushant.userservice.dtos.UserDto;
import com.sushant.userservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        UserDto userDto = authService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> sendEmail() {
        return new ResponseEntity<String>("posted to topic email", HttpStatus.OK);
    }
}
