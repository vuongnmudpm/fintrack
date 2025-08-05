package com.vuongnm.fintrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    @Id
    @Column(name = "user_id")
    private int userId;
    private String username;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "fullName")
    private String fullName;
    private String phone;

    @Column(name = "avatar_url")
    private String avatarUrl;
    private Date dob;
    private String role;
    private String status;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime updatedAt;
}
