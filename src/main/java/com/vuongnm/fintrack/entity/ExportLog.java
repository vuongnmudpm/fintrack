package com.vuongnm.fintrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "export_logs")
@Data
public class ExportLog {
    @Id
    @Column(name = "export_id")
    private Integer exportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "export_type", nullable = false, length = 10)
    private String exportType; // PDF, EXCEL

    @Column(name = "status", length = 20)
    private String status = "SUCCESS"; // SUCCESS, FAILED

    @Column(name = "export_time")
    private LocalDateTime exportTime;

    @Column(name = "file_path", length = 255)
    private String filePath;

    @Column(name = "file_size_kb")
    private Integer fileSizeKb;

    @Lob
    @Column(name = "filter_info")
    private String filterInfo; // JSON chuỗi

    @Column(name = "requested_by_ip", length = 45)
    private String requestedByIp;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
