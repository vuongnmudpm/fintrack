package com.vuongnm.fintrack.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class Reminder {
    @Id
    @Column(name = "reminder_id")
    private Integer reminderId;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "reminder_time", nullable = false)
    private LocalDateTime reminderTime;

    @Column(name = "is_sent", nullable = false)
    private Boolean isSent = false;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @Column(name = "repeat_interval", length = 20)
    private String repeatInterval; // NONE / DAILY / WEEKLY / MONTHLY / YEARLY

    @Column(name = "channel", length = 20)
    private String channel = "APP"; // APP / EMAIL / SMS

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
