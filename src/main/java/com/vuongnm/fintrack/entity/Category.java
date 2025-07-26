package com.vuongnm.fintrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {
    @Id
    private int category_id;
    private String name;
    private String type;
    private String description;
    private String color_code;
    private String icon;
    private Boolean is_default;
    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAt;
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user_id;
}
