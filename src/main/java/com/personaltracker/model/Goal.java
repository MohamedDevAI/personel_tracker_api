package com.personaltracker.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
