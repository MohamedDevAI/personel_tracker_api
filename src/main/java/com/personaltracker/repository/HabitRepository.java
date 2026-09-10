package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.Habit;

import java.util.List;

@Repository
public interface HabitRepository extends MongoRepository<Habit, String> {
    List<Habit> findByCategory(String category);
}
