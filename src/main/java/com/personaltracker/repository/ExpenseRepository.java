package com.personaltracker.repository;

import com.personaltracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByType(String type);
    List<Expense> findByCategory(String category);
}
