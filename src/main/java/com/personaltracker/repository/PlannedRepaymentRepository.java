package com.personaltracker.repository;

import com.personaltracker.model.PlannedRepayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannedRepaymentRepository extends MongoRepository<PlannedRepayment, String> {
    List<PlannedRepayment> findByCreditorName(String creditorName);
    List<PlannedRepayment> findByStatus(String status);
    List<PlannedRepayment> findByTargetMonth(String targetMonth);
}
