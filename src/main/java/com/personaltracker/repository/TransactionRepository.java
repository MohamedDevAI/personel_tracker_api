package com.personaltracker.repository;

import com.personaltracker.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByDateBetween(Date startDate, Date endDate);
    List<Transaction> findByCategory(String category);
    List<Transaction> findByMonth(String month);
    List<Transaction> findByType(String type);
    List<Transaction> findByPaymentMethod(String paymentMethod);
}
