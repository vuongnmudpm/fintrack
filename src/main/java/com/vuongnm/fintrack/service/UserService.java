package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.User;
import com.vuongnm.fintrack.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //dang ky nguoi dung moi
    public User register(User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username đã tồn tại");
        }
        if(userRepository.existByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email đã tồn tại");
        }

        user.setPassword_hash(passwordEncoder.encode(user.getPassword_hash()));
        return userRepository.save(user);
    }

    //dang nhap nguoi dung
    public User login(String usernameOrEmail, String rawPassword) {
        Optional<User> userOpt = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
        if(userOpt.isEmpty()) {
            throw new IllegalArgumentException("Tài khoản không tồn tại");
        }
        User user = userOpt.get();
        if(!passwordEncoder.matches(rawPassword, user.getPassword_hash())) {
            throw new IllegalArgumentException("Mật khẩu không chính xác");
        }
        return user;
    }

    //cap nhat thong tin nguoi dung
    public User updateUser(Integer userId, User updateData) {
        User existingUser = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User không tồn tại"));

        if(updateData.getFull_name() != null) {
            existingUser.setFull_name(updateData.getFull_name());
        }

        if(updateData.getEmail() != null) {
            existingUser.setEmail(updateData.getEmail());
        }

        if(updateData.getPassword_hash() != null) {
            existingUser.setPassword_hash(updateData.getPassword_hash());
        }

        return userRepository.save(existingUser);

    }
}
