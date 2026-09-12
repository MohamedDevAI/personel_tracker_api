package com.personaltracker.service;

import com.personaltracker.model.BorrowRepayRecord;
import com.personaltracker.repository.BorrowRepayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowRepayService {

    private final BorrowRepayRepository repository;

    public List<BorrowRepayRecord> getAll() {
        return repository.findAll();
    }

    public Optional<BorrowRepayRecord> getById(String id) {
        return repository.findById(id);
    }

    public List<BorrowRepayRecord> getByCreditorName(String creditorName) {
        return repository.findByCreditorName(creditorName);
    }

    public List<BorrowRepayRecord> getByType(String type) {
        return repository.findByType(type);
    }

    public BorrowRepayRecord save(BorrowRepayRecord record) {
        if (record.getCurrency() == null || record.getCurrency().isBlank()) {
            record.setCurrency("INR");
        }
        if (record.getAmount() != null) {
            record.setAmount(Math.abs(record.getAmount()));
        }
        if (record.getCreatedAt() == null || record.getCreatedAt().isBlank()) {
            record.setCreatedAt(Instant.now().toString());
        }
        return repository.save(record);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public long count() {
        return repository.count();
    }
}
