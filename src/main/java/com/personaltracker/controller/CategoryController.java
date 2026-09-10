package com.personaltracker.Controller;

import com.personaltracker.Model.Category;
import com.personaltracker.Model.TransactionType;
import com.personaltracker.Service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String type) {
        if (type != null && !type.isBlank()) {
            TransactionType txType = TransactionType.fromString(type);
            if (txType != null) {
                return ResponseEntity.ok(categoryService.getCategoriesByType(txType));
            }
        }
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
