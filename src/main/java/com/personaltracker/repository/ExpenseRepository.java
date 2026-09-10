package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.Expense;

import java.util.List;

@Repository
public interface ExpenseRepository extends

    List<Expense> findByType(String type);
    List<Expense> findByCategory(String category);
}
