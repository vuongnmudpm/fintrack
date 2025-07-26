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

    //get a reminder by id
    public Reminder getReminder(Integer reminderId) {
        return reminderRepository.findById(reminderId).orElseThrow(()->new RuntimeException("Reminder not found with " + reminderId));
    }

    //create a reminder
    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }
}
