package com.personaltracker.Service;

import com.personaltracker.Model.DashboardSummary;
import com.personaltracker.Model.Transaction;
import com.personaltracker.Repository.TransactionRepository;

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
            Double amt = t.g
                tAmount();
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
