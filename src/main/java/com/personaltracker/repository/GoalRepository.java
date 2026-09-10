package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.Goal;

import java.util.List;

@Repository
public interface GoalRepository extends MongoRepository<Goal, String> {
    List<Goal> findByStatus(String status);
}
