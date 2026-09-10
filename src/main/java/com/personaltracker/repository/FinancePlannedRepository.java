package com.personaltracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.personaltracker.Model.FinancePlanned;

import java.util.List;

@Repository
public interface FinancePlannedRepository extends M

    List<FinancePlanned> findByMonth(String month)

    List<FinancePlanned> findByYear(Integer year);

    List<FinancePlanned> findByMonthAndYear(String month, Integer year);
    List<FinancePlanned> findByCategory(String category);
}
