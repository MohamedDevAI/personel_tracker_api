package com.personaltracker.Controller;

import com.personaltracker.Model.Transaction;
import com.personaltracker.Service.TransactionService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type) {
        if (month != null && !month.isBlank()) {
            return ResponseEntity.ok(transactionService.getTransactionsByMonth(month));
        }
        if (category != null && !category.isBlank()) {
            return ResponseEntity.ok(transactionService.getTransactionsByCategory(category));
        }
        if (type != null && !type.isBlank()) {
            return ResponseEntity.ok(transactionService.getTransactionsByType(type));
        }
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String id,
            @RequestBody Transaction transaction) {
        transaction.setId(id);
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
