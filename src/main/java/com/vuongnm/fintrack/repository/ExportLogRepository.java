package com.vuongnm.fintrack.repository;

import com.vuongnm.fintrack.entity.ExportLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportLogRepository extends JpaRepository<ExportLog, Integer> {
}
