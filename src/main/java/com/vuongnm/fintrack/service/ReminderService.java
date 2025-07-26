package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.Reminder;
import com.vuongnm.fintrack.repository.ReminderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReminderService {
    private final ReminderRepository reminderRepository;

    //get all reminders
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }
}
