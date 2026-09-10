package com.personaltracker.Controller;

import com.personaltracker.Model.TaskItem;
import com.personaltracker.Service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskItem>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<TaskItem> createTask(@RequestBody TaskItem task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PostMapping("/{id}/toggle")
    public ResponseEntity<TaskItem> toggleTask(@PathVariable String id) {
        return taskService.toggleTask(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
