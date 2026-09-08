package com.personaltracker.repository;

import com.personaltracker.model.TaskItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskItemRepository extends MongoRepository<TaskItem, String> {
    List<TaskItem> findByCompleted(boolean completed);
    List<TaskItem> findByPriority(String priority);
}
