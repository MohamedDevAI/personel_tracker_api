package com.personaltracker.repository;

import com.personaltracker.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByType(com.personaltracker.model.TransactionType type);
}
