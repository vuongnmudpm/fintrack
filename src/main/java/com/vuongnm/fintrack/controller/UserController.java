package com.vuongnm.fintrack.controller;

import com.vuongnm.fintrack.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vuongnm.fintrack.entity.User;


@RestController
@RequestMapping("/users")
public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    //GET/users/me
//    @GetMapping("/me")
//    public ResponseEntity<User> getCurrentUser(Authentication authentication) {
//        String username = authentication.getName();
//        User user = userService.getByUsername(username);
//        return ResponseEntity.ok(user);
//    }
//
//    //GET/users/{id}
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
//        User user = userService.getById(id);
//        return ResponseEntity.ok(user);
//    }
}
