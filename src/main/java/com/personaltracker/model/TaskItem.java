package com.personaltracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class TaskItem {

    @Id
    private String id;
    private String title;
    private String category;
    private String priority; // "HIGH", "MEDIUM", "LOW"
    private boolean completed;
    private String dueDate;

    public TaskItem() {}

    public TaskItem(String id, String title, String category, String priority, boolean completed, String dueDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
}
