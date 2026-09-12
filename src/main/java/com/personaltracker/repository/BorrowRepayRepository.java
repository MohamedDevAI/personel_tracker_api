package com.personaltracker.repository;

import com.personaltracker.model.BorrowRepayRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepayRepository extends MongoRepository<BorrowRepayRecord, String> {
    List<BorrowRepayRecord> findByCreditorName(String creditorName);
    List<BorrowRepayRecord> findByType(String type);
    List<BorrowRepayRecord> findByCreditorNameAndType(String creditorName, String type);
}
