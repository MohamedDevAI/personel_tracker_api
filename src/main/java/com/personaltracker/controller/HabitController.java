package com.personaltracker.Controller;

import com.personaltracker.Model.Habit;
import com.personaltracker.Service.HabitService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public ResponseEntity<List<Habit>> getAllHabits() {
        return ResponseEntity.ok(habitService.getAllHabits());
    }

    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
        return ResponseEntity.ok(habitService.createHabit(habit));
    }

    @PostMapping("/{id}/toggle")
    public ResponseEntity<Habit> toggleHabit(@PathVariable String id) {
        return habitService.toggleHabit(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable String id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
