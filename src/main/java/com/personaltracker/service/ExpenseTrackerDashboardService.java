package com.personaltracker.service;

import com.personaltracker.model.DashboardSummary;
import com.personaltracker.model.Transaction;
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

    public DashboardSummary getExpenseSummary() {
        List<Transaction> transactions = transactionRepository.findAll();

        double totalCredit = 0.0;
        double totalDebit = 0.0;
        Map<String, Double> expensesByCategory = new HashMap<>();

        for (Transaction t : transactions) {
            Double amt = t.getAmount();
            if (amt == null) continue;

            if (t.isCredit()) {
                totalCredit += Math.abs(amt);
            } else if (t.isDebit()) {
                double debitAmt = Math.abs(amt);
                totalDebit += debitAmt;
                String catName = (t.getCategory() != null && !t.getCategory().isBlank())
                        ? t.getCategory()
                        : "Uncategorized";
                expensesByCategory.put(catName, expensesByCategory.getOrDefault(catName, 0.0) + debitAmt);
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
