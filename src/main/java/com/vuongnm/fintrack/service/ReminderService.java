package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.Reminder;
import com.vuongnm.fintrack.repository.ReminderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReminderService {
//    private final ReminderRepository reminderRepository;
//
//    //get all reminders
//    public List<Reminder> getAllReminders() {
//        return reminderRepository.findAll();
//    }
//
//    //get a reminder by id
//    public Reminder getReminderById(Integer reminderId) {
//        return reminderRepository.findById(reminderId).orElseThrow(()->new RuntimeException("Reminder not found with " + reminderId));
//    }
//
//    //create a reminder
//    public Reminder createReminder(Reminder reminder) {
//        return reminderRepository.save(reminder);
//    }
//
//    //update a reminder
//    public Reminder updatedReminder(Integer reminderId, Reminder reminder) {
//        return reminderRepository.save(reminder);
//    }
//
//    //delete a reminder
//    public boolean deleteReminder(Integer reminderId) {
//        if(reminderRepository.findById(reminderId).isEmpty()) {
//            throw new EntityNotFoundException("Reminder not exist!");
//        }
//        reminderRepository.deleteById(reminderId);
//        return false;
//    }
}
