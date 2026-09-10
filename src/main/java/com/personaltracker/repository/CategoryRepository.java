package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByType(com.personaltracker.Model.TransactionType type);
}
