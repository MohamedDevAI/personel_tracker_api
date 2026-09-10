package com.personaltracker.Service;

import com.personaltracker.Model.FinancePlanned;
import com.personaltracker.Repository.FinancePlannedRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinancePlannedService {

    private final FinancePlannedRepository repository;

    public List<FinancePlanned> getAll() {
        return repository.findAll();
    }

    public List<FinancePlanned> getByMonthAndYear(String month, Integer year) {
        if (month != null && !month.isBlank() && year != null) {
            return repository.findByMonthAndYear(month, year);
        }
        if (month != null && !month.isBlank()) {
            return repository.findByMonth(month);
        }
        if (year != null) {
            return repository.findByYear(year);
        }
        return repository.findAll();
    }

    public Optional<FinancePlanned> getById(String id) {
        return repository.findById(id);
    }

    public FinancePlanned save(FinancePlanned plan) {
        if (plan.getCurrency() == null || plan.getCurrency().isBlank()) {
            plan.setCurrency("SAR");
        }
        if (plan.getIsFulfilled() == null) {
            boolean fulfilled = "Fulfilled".equalsIgnoreCase(plan.getStatus()) ||
                            
                    (plan.getPaidAmount() != null && plan.getPlannedAmount() != null && plan.getPaidAmount() >= plan.getPlannedAmount());
            plan.setIsFulfilled(fulfilled);
        }
        if (Boolean.TRUE.equals(plan.getIsFulfilled()) && (plan.getPaidAmount() == null || plan.getPaidAmount() == 0)) {
            plan.setPaidAmount(plan.getPlannedAmount());
        }
        return repository.save(plan);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<FinancePlanned> saveAll(List<FinancePlanned> plans) {
        return repository.saveAll(plans);
    }

    public long count() {
        return repository.count();
    }
}
