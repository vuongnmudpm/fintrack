package com.vuongnm.fintrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(length = 10, nullable = false)
    private String type; // INCOME or EXPENSE

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod; // cash, bank, momo, etc.

    @Column(length = 255)
    private String note;

    @Lob
    private String description;

    @Column(name = "receipt_image_url", length = 255)
    private String receiptImageUrl;

    @Column(name = "is_recurring", nullable = false)
    private Boolean isRecurring = false;

    @Column(name = "recurring_interval", length = 20)
    private String recurringInterval; // DAILY, MONTHLY, etc.

    @Column(length = 20)
    private String status = "COMPLETED"; // COMPLETED, PENDING, CANCELLED

    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
