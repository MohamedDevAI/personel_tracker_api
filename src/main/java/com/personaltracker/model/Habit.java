package com.personaltracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "habits")
public class Habit {

    @Id
    private String id;
    private String title;
    private String category;
    private int streak;
    private String targetFrequency; // e.g., "Daily", "Weekdays"
    private boolean completedToday;

    @Builder.Default
    private List<Integer> history = new ArrayList<>();
}
