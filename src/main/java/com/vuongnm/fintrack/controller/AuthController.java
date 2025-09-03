package com.vuongnm.fintrack.controller;

import com.vuongnm.fintrack.dto.AuthResponse;
import com.vuongnm.fintrack.dto.LoginRequest;
import com.vuongnm.fintrack.dto.RegisterRequest;
import com.vuongnm.fintrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello, ai cũng truy cập được!";
    }

    @GetMapping("/private/hello")
    public String privateHello() {
        return "Hello, chỉ user đã login mới thấy!";
    }

//    private final UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
//        AuthResponse response = userService.register(request);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
//        AuthResponse response = userService.login(request);
//        return ResponseEntity.ok(response);
//    }
}
