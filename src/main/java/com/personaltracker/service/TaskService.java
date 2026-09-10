package com.personaltracker.Service;

import com.personaltracker.Model.TaskItem;
import com.personaltracker.Repository.TaskItemRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskItemRepository repository;

    public TaskService(TaskItemRepository repository) {
        this.repository = repository;
    }

    public List<TaskItem> getAllTasks() {
        return repository.findAll();
    }

    public TaskItem createTask(TaskItem task) {
        return repository.save(task);
    }

    public Optional<TaskItem> toggleTask(String id) {
        return repository.findById(id).map(task -> {
            task.setCompleted(!task.isCompleted());
            return repository.save(task);
        });
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}
