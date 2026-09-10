package com.personaltracker.Service;

import com.personaltracker.Model.Expense;
import com.personaltracker.Repository.ExpenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Optional<Expense> getExpenseById(String id) {
        return repository.findById(id);
    }

    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    public void deleteExpense(String id) {
        repository.deleteById(id);
    }
}
