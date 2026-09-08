package com.personaltracker.service;

import com.personaltracker.model.Category;
import com.personaltracker.model.DashboardSummary;
import com.personaltracker.model.Transaction;
import com.personaltracker.model.TransactionType;
import com.personaltracker.repository.CategoryRepository;
import com.personaltracker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExpenseTrackerDashboardService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public DashboardSummary getExpenseSummary() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        Map<String, String> categoryNameMap = new HashMap<>();
        for (Category cat : categories) {
            categoryNameMap.put(cat.getId(), cat.getName());
        }

        double totalCredit = 0.0;
        double totalDebit = 0.0;
        Map<String, Double> expensesByCategory = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getAmountSar() == null) continue;

            if (t.getType() == TransactionType.CREDIT) {
                totalCredit += t.getAmountSar();
            } else if (t.getType() == TransactionType.DEBIT) {
                totalDebit += t.getAmountSar();
                String catName = categoryNameMap.getOrDefault(t.getCategoryId(), "Unknown");
                expensesByCategory.put(catName, expensesByCategory.getOrDefault(catName, 0.0) + t.getAmountSar());
            }
        }

        return DashboardSummary.builder()
                .totalCredit(totalCredit)
                .totalDebit(totalDebit)
                .balance(totalCredit - totalDebit)
                .expensesByCategory(expensesByCategory)
                .build();
    }
}
