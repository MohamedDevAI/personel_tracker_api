package com.personaltracker.service;

import com.personaltracker.model.Transaction;
import com.personaltracker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByMonth(String month) {
        return transactionRepository.findByMonth(month);
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    public List<Transaction> getTransactionsByType(String type) {
        return transactionRepository.findByType(type);
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        // Normalize and ensure compatibility with actual MongoDB document structure
        if (transaction.getDate() == null) {
            transaction.setDate(new Date());
        }
        if (transaction.getMonth() == null || transaction.getMonth().isBlank()) {
            SimpleDateFormat monthFmt = new SimpleDateFormat("MMM", Locale.ENGLISH);
            monthFmt.setTimeZone(TimeZone.getTimeZone("UTC"));
            transaction.setMonth(monthFmt.format(transaction.getDate()));
        }
        if (transaction.getPaymentMethod() == null || transaction.getPaymentMethod().isBlank()) {
            transaction.setPaymentMethod("Account");
        }
        if (transaction.getDescription() == null && transaction.getNote() != null) {
            transaction.setDescription(transaction.getNote());
        }
        if (transaction.getAmount() == null && transaction.getAmountSar() != null) {
            transaction.setAmount(transaction.getAmountSar());
        }
        if (transaction.getCategory() == null && transaction.getCategoryId() != null) {
            transaction.setCategory(transaction.getCategoryId());
        }
        if (transaction.getType() != null) {
            if ("credit".equalsIgnoreCase(transaction.getType())) {
                transaction.setType("Credit");
            } else if ("debit".equalsIgnoreCase(transaction.getType())) {
                transaction.setType("Debit");
            }
        }
        if (transaction.getAmount() != null) {
            if (transaction.isDebit()) {
                transaction.setAmount(-Math.abs(transaction.getAmount()));
            } else if (transaction.isCredit()) {
                transaction.setAmount(Math.abs(transaction.getAmount()));
            }
        }
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }
}
