package com.personaltracker.repository;

import com.personaltracker.model.FinancePlanned;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancePlannedRepository extends MongoRepository<FinancePlanned, String> {
    List<FinancePlanned> findByMonth(String month);
    List<FinancePlanned> findByYear(Integer year);
    List<FinancePlanned> findByMonthAndYear(String month, Integer year);
    List<FinancePlanned> findByCategory(String category);
}
