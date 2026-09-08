package com.personaltracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "goals")
public class Goal {

    @Id
    private String id;
    private String title;
    private String category;
    private String targetDate;
    private int progress; // 0 to 100
    private double targetValue;
    private double currentValue;
    private String unit;
    private String status; // "IN_PROGRESS", "NEAR_COMPLETION", "COMPLETED"

    public Goal() {}

    public Goal(String id, String title, String category, String targetDate, int progress, double targetValue, double currentValue, String unit, String status) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.targetDate = targetDate;
        this.progress = progress;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.unit = unit;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getTargetDate() { return targetDate; }
    public void setTargetDate(String targetDate) { this.targetDate = targetDate; }

    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }

    public double getTargetValue() { return targetValue; }
    public void setTargetValue(double targetValue) { this.targetValue = targetValue; }

    public double getCurrentValue() { return currentValue; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
