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
@Document(collection = "tasks")
public class TaskItem {

    @Id
    private String id;
    private String title;
    private String category;
    private String priority; // "HIGH", "MEDIUM", "LOW"
    private boolean completed;
    private String dueDate;
}
