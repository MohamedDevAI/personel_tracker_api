package com.personaltracker.service;

import com.personaltracker.model.PlannedRepayment;
import com.personaltracker.repository.PlannedRepaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlannedRepaymentService {

    private final PlannedRepaymentRepository repository;

    public List<PlannedRepayment> getAll() {
        return repository.findAll();
    }

    public Optional<PlannedRepayment> getById(String id) {
        return repository.findById(id);
    }

    public List<PlannedRepayment> getByCreditorName(String creditorName) {
        return repository.findByCreditorName(creditorName);
    }

    public List<PlannedRepayment> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    public PlannedRepayment save(PlannedRepayment plan) {
        if (plan.getPlannedAmount() != null) {
            plan.setPlannedAmount(Math.abs(plan.getPlannedAmount()));
        }
        if (plan.getStatus() == null || plan.getStatus().isBlank()) {
            plan.setStatus("Scheduled");
        }
        if (plan.getCreatedAt() == null || plan.getCreatedAt().isBlank()) {
            plan.setCreatedAt(Instant.now().toString());
        }
        return repository.save(plan);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public long count() {
        return repository.count();
    }
}
