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
    private int user_id;
    private String username;
    private String email;
    private String password_hash;
    private String full_name;
    private String phone;
    private String avatar_url;
    private Date dob;
    private String role;
    private String status;
    private Boolean is_verified;
    private Date last_login;
    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAt;
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime updatedAt;
}
