package com.personaltracker.service;

import com.personaltracker.model.Goal;
import com.personaltracker.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    private final GoalRepository repository;

    public GoalService(GoalRepository repository) {
        this.repository = repository;
    }

    public List<Goal> getAllGoals() {
        return repository.findAll();
    }

    public Goal createGoal(Goal goal) {
        if (goal.getStatus() == null) {
            goal.setStatus("IN_PROGRESS");
        }
        return repository.save(goal);
    }

    public Optional<Goal> updateProgress(String id, int progress) {
        return repository.findById(id).map(g -> {
            int clamped = Math.max(0, Math.min(100, progress));
            g.setProgress(clamped);
            if (clamped >= 100) {
                g.setStatus("COMPLETED");
            } else if (clamped >= 80) {
                g.setStatus("NEAR_COMPLETION");
            } else {
                g.setStatus("IN_PROGRESS");
            }
            return repository.save(g);
        });
    }

    public void deleteGoal(String id) {
        repository.deleteById(id);
    }
}
