package com.personaltracker.Service;

import com.personaltracker.Model.Category;
import com.personaltracker.Model.Transaction;
import com.personaltracker.Model.TransactionType;
import com.personaltracker.Repository.CategoryRepository;
import com.personaltracker.Repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>(categoryRepository.findAll());
        Set<String> existingNames = categories.stream()
                .map(Category::getName)
                .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        // 
        // Dynamically include categories present in transactions if not in categories collection
        List<Transaction> transactions = transactionRepository.findAll();
        for (Transaction tx : transactions) {
            String catName = tx.getCategory();
            if (catName != null && !catName.isBlank() && !existingNames.contains(catName.toLowerCase())) {
                Category discovered = Category.builder()
                        .id(catName)
                        .name(catName)
                        .type(tx.isCredit() ? TransactionType.CREDIT : TransactionType.DEBIT)
                        .build();
                categories.add(discovered);
                existingNames.add(catName.toLowerCase());
            }
        }
        return categories;
    }

    public List<Category> getCategoriesByType(TransactionType type) {
        return getAllCategories().stream()
                .filter(c -> c.getType() == type)
                .collect(Collectors.toList());
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}
