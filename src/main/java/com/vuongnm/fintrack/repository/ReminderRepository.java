package com.vuongnm.fintrack.repository;

import com.vuongnm.fintrack.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
}
