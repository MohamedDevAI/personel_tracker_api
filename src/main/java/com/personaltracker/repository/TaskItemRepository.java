package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.TaskItem;

import java.util.List;

@Repository
public interface TaskItemRepository extends MongoRepos

    List<TaskItem> findByCompleted(boolean completed);
    List<TaskItem> findByPriority(String priority);
}
