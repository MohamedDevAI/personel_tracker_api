package com.personaltracker.service;

import com.personaltracker.model.Habit;
import com.personaltracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    private final HabitRepository repository;

    public HabitService(HabitRepository repository) {
        this.repository = repository;
    }

    public List<Habit> getAllHabits() {
        return repository.findAll();
    }

    public Habit createHabit(Habit habit) {
        if (habit.getHistory() == null || habit.getHistory().isEmpty()) {
            List<Integer> initialHistory = new ArrayList<>();
            for (int i = 0; i < 7; i++) initialHistory.add(0);
            habit.setHistory(initialHistory);
        }
        return repository.save(habit);
    }

    public Optional<Habit> toggleHabit(String id) {
        return repository.findById(id).map(habit -> {
            boolean nextState = !habit.isCompletedToday();
            habit.setCompletedToday(nextState);
            int streak = habit.getStreak();
            habit.setStreak(nextState ? streak + 1 : Math.max(0, streak - 1));

            List<Integer> history = habit.getHistory();
            if (history == null) history = new ArrayList<>();
            if (history.size() >= 7) {
                history = new ArrayList<>(history.subList(1, history.size()));
            }
            history.add(nextState ? 1 : 0);
            habit.setHistory(history);

            return repository.save(habit);
        });
    }

    public void deleteHabit(String id) {
        repository.deleteById(id);
    }
}
