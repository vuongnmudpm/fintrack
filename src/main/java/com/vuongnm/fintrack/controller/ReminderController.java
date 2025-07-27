package com.vuongnm.fintrack.controller;

import com.vuongnm.fintrack.entity.Reminder;
import com.vuongnm.fintrack.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
@RequiredArgsConstructor
public class ReminderController {
    private final ReminderService reminderService;

    //Get all reminders
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = reminderService.getAllReminders();
        return ResponseEntity.ok(reminders);
    }

    //Get a reminder by id
    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Integer reminderId) {
        Reminder reminder = reminderService.getReminderById(reminderId);
        return ResponseEntity.ok(reminder);
    }

    //Create a new reminder
    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder created = reminderService.createReminder(reminder);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //Update a reminder
    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Integer reminderId, @RequestBody Reminder reminder) {
        Reminder updated = reminderService.updatedReminder(reminderId, reminder);
        if(updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete a reminder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Integer reminderId) {
        boolean deleted = reminderService.deleteReminder(reminderId);
        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
