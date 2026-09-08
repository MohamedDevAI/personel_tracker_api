package com.personaltracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "habits")
public class Habit {

    @Id
    private String id;
    private String title;
    private String category;
    private int streak;
    private String targetFrequency; // e.g., "Daily", "Weekdays"
    private boolean completedToday;
    private List<Integer> history = new ArrayList<>();

    public Habit() {}

    public Habit(String id, String title, String category, int streak, String targetFrequency, boolean completedToday, List<Integer> history) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.streak = streak;
        this.targetFrequency = targetFrequency;
        this.completedToday = completedToday;
        this.history = history != null ? history : new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStreak() { return streak; }
    public void setStreak(int streak) { this.streak = streak; }

    public String getTargetFrequency() { return targetFrequency; }
    public void setTargetFrequency(String targetFrequency) { this.targetFrequency = targetFrequency; }

    public boolean isCompletedToday() { return completedToday; }
    public void setCompletedToday(boolean completedToday) { this.completedToday = completedToday; }

    public List<Integer> getHistory() { return history; }
    public void setHistory(List<Integer> history) { this.history = history; }
}
