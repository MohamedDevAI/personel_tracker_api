package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.Transaction;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transac

    List<Transaction> findByDateBetween(Date startDate

    List<Transaction> findByCategory(String cate

    List<Transaction> findByMonth(String month

    List<Transaction> findByType(String type);
    List<Transaction> findByPaymentMethod(String paymentMethod);
}
